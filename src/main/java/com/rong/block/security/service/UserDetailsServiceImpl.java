package com.rong.block.security.service;

import com.rong.block.dao.UserMapper;
import com.rong.block.exception.BadRequestException;
import com.rong.block.pojo.DeptSmallDto;
import com.rong.block.pojo.JobSmallDto;
import com.rong.block.pojo.UserDto;
import com.rong.block.security.vo.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("userDetailsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    @Autowired
    public UserDetailsServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userMapper.findUserByName(username);
        if (userDto == null) {
            throw new BadRequestException("账号不存在");
        } else {
            if (!userDto.getEnabled()) {
                throw new BadRequestException("账号未激活");
            }
            return createJwtUser(userDto);
        }
    }

    private UserDetails createJwtUser(UserDto user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getNickName(),
                user.getSex(),
                user.getPassword(),
                user.getAvatar(),
                user.getEmail(),
                user.getPhone(),
                Optional.ofNullable(user.getDept()).map(DeptSmallDto::getName).orElse(null),
                Optional.ofNullable(user.getJob()).map(JobSmallDto::getName).orElse(null),
//                roleService.mapToGrantedAuthorities(user),
                null,
                user.getEnabled(),
                user.getCreateTime(),
                user.getLastPasswordResetTime()
        );
    }
}
