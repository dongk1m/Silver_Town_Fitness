package com.stf.page.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
//	private static final String SALT = "SSAFIT";
	private static final String SALT = "STF";

	
	//토큰 생성
	//인자로 키와 벨류가 넘어왔다고 생각하고 처리
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
	//테스트하는데 방해되는 유효기간은 잠시 지운다..
		return Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT")
				.claim(claimId, data)
				.signWith(SignatureAlgorithm.HS256, "STF".getBytes("UTF-8"))
				.compact();
	}
	
	//유효성 검사
	public void valid(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {
		Jwts.parser().setSigningKey("STF".getBytes("UTF-8")).parseClaimsJws(token);
	}
}
