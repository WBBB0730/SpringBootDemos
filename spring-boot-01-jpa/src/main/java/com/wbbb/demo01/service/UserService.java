package com.wbbb.demo01.service;

import com.wbbb.demo01.dto.response.data.LoginResponseDataDto;
import com.wbbb.demo01.entity.User;
import com.wbbb.demo01.repository.UserRepository;
import com.wbbb.demo01.util.CryptoUtil;
import com.wbbb.demo01.util.SymbolGenerateUtil;
import com.wbbb.demo01.util.TokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    /**
     * 检测账户名称是否可用
     */
    public boolean checkUsernameAvailable(String username) {
        return !userRepository.existsByUsername(username);
    }

    /**
     * 注册
     */
    public void join(String email, String username, String password) {
        password = CryptoUtil.SHA256(password);
        BigInteger userId;
        do
            userId = SymbolGenerateUtil.generateUserId();
        while (userRepository.existsById(userId));
        User user = new User(userId, username, password, email, System.currentTimeMillis());
        userRepository.save(user);
    }

    /**
     * 登录
     * @return 登录成功返回{ token, userId }，失败返回null
     */
    public LoginResponseDataDto login(String username, String password) {
        password = CryptoUtil.SHA256(password);
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null)
            return null;
        return new LoginResponseDataDto(TokenUtil.generateToken(user), user.getUserId());
    }
}
