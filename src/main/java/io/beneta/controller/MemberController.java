package io.beneta.controller;

import io.beneta.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/member")
public class MemberController {

    private final MemberService memberService;




}
