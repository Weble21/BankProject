package org.example.domains.auth.service

import org.example.common.exception.CustomException
import org.example.common.exception.ErrorCode
import org.example.common.jwt.JwtProvider
import org.example.interfaces.OAuthServiceInterface
import org.springframework.stereotype.Service

@Service
class AuthService(
    //앞서 작성된 oAuth key값을 받음
    private val oAuth2Services: Map<String, OAuthServiceInterface>,
    private val jwtProvider: JwtProvider
) {
    fun handleAuth(state: String, code : String) : String {
        //값을 소문자로 받아야 됨. GOOGLE -> google
        val provider = state.lowercase()
        val callService = oAuth2Services[provider] ?: throw CustomException(ErrorCode.PROVIDER_NOT_FOUND, provider)

        val accessToken = callService.getToken(code)
        val userInfo = callService.getUserInfo(accessToken.accessToken)
        val token = jwtProvider.createToken(provider, userInfo.email, userInfo.name, userInfo.id)

        //userInfo
    }
}