package jpabook.merchandiseManagement.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberFrom {

    @NotEmpty(message = "이메일 입력은 필수 입니다.")
    private String email;

    private String name;

    private String position;

    @NotEmpty(message = "비밀번호 입력은 필수 입니다.")
    private String password;
}
