package com.oauth2google.sample;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String publicApi() {
        return "This API is public!";
    }

    @RequestMapping(value="/protected", method=RequestMethod.GET)
    public String protectedApi() {
        return "You are authenticated!";
    }

    @RequestMapping("/login-success")
    public String loginSuccess() {
    	// defaultSuccessUrlで定義しているので，ログインに成功すると，このAPIが呼ばれる．
    	// とりあえずMDNのページにリダイレクトする．
    	return "<head><meta http-equiv=\"refresh\" content=\"0; URL=https://developer.mozilla.org/en-US/docs/Web/HTTP/Redirections#HTML_redirections\" /></head>";
    }

    @RequestMapping("/logout-success")
    public String logoutSuccess() {
    	// logoutSuccessUrlで定義しているので，ログアウトに成功すると，このAPIが呼ばれる．
    	return "";
    }

    @RequestMapping("/user")
    public Principal user(Principal principal) {
    	// 認証済みの人がこのAPIを叩くと，printipalを返す．
    	return principal;
    }
}
