package com.school.exceptions;

import java.time.LocalDateTime;

public record ErrorResponseDTO(
        String message,
        String detailedMessage,
        LocalDateTime errorTime
) {
}
