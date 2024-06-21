package com.backend.tripmate.iam.domain.model.commands;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
