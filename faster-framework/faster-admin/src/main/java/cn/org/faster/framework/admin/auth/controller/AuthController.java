package cn.org.faster.framework.admin.auth.controller;

import cn.org.faster.framework.admin.auth.model.LoginReq;
import cn.org.faster.framework.admin.auth.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangbowen
 */
@RestController
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    /**
     * 登录
     *
     * @param loginReq 登录实体
     * @return 登录成功实体
     */
    @PostMapping("/login")
    public ResponseEntity login(@Validated @RequestBody LoginReq loginReq) {
        return authService.login(loginReq);
    }

    /**
     * @return 获取权限列表
     */
    @GetMapping("/permissions")
    public ResponseEntity permissions() {
        return ResponseEntity.ok(authService.permissions());
    }

    /**
     * 退出登录
     *
     * @return httpResponse
     */
    @DeleteMapping("/logout")
    public ResponseEntity logout() {
        authService.logout();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
