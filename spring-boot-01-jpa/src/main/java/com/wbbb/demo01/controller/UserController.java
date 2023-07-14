package com.wbbb.demo01.controller;

import com.wbbb.demo01.dto.request.JoinRequestDto;
import com.wbbb.demo01.dto.request.LoginRequestDto;
import com.wbbb.demo01.dto.response.ResponseDto;
import com.wbbb.demo01.dto.response.data.LoginResponseDataDto;
import com.wbbb.demo01.service.UserService;
import com.wbbb.demo01.util.ValidateUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    /**
     * 检查账户名称是否可用
     */
    @GetMapping("/available")
    public ResponseDto<Boolean> checkUsernameAvailable(@RequestParam("username") String username) {
        if (username.isEmpty())
            return ResponseDto.success(false);
        return ResponseDto.success(userService.checkUsernameAvailable(username));
    }

    /**
     * 注册
     */
    @PostMapping("/join")
    public ResponseDto<?> join(@RequestBody JoinRequestDto joinRequestDto) {
        if (!ValidateUtil.isEmailValid(joinRequestDto.getEmail()))
            return ResponseDto.badRequest(null, "请输入有效的电子邮件地址");
        if (!userService.checkUsernameAvailable(joinRequestDto.getUsername()))
            return ResponseDto.conflict(null, "账户名称不可用");
        userService.join(joinRequestDto.getEmail(), joinRequestDto.getUsername(), joinRequestDto.getPassword());
        return ResponseDto.success(null, "注册成功");
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public ResponseDto<LoginResponseDataDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDataDto loginResponseDataDto = userService.login(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        if (loginResponseDataDto == null)
            return ResponseDto.notFound(null, "请核对您的密码和帐户名称并重试。");
        return ResponseDto.success(loginResponseDataDto, "登录成功");
    }
}
