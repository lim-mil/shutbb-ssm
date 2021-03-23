package com.limyel.shutbb.controller;

import com.google.code.kaptcha.Producer;
import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {
    private Producer kaptchaProducer;
    private RedisUtil redisUtil;

    @Autowired
    public void setKaptchaProducer(Producer kaptchaProducer) {
        this.kaptchaProducer = kaptchaProducer;
    }

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @GetMapping("")
    @IgnoreAuth
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OutputStream out = response.getOutputStream();
        String key = UUID.randomUUID().toString();
        String capText = kaptchaProducer.createText();
        redisUtil.getRedisTemplate().opsForHash().put("shutbb_captcha", key, capText);
        request.getSession().setAttribute("captcha_key", key);
        BufferedImage bi = kaptchaProducer.createImage(capText);
        ImageIO.write(bi, "jpg", out);
        out.flush();
    }

    @GetMapping("/check/{captcha}")
    @IgnoreAuth
    @ResponseBody
    public Response checkCaptcha(@PathVariable String captcha, HttpServletRequest request, HttpServletResponse response) {
        String key = (String) request.getSession().getAttribute("captcha_key");
        if (key == null)
            return Response.badRequest();
        String captchaValue = (String) redisUtil.getRedisTemplate().opsForHash().get("shutbb_captcha", key);
        if (captchaValue.toLowerCase().equals(captcha.toLowerCase())) {
            return Response.success();
        }
        redisUtil.getRedisTemplate().opsForHash().delete("shutbb_captcha", key);
        return Response.badRequest();
    }
}
