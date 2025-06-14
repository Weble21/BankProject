package org.example.common.exception

import org.aspectj.bridge.Message

class CustomException (
    private val codeInterface : CodeInterface,
    private val additionalMessage: String? = null
) : RuntimeException(
    if (additionalMessage == null) {
        codeInterface.message
    } else {
        "${codeInterface.message} - $additionalMessage"
    }
)