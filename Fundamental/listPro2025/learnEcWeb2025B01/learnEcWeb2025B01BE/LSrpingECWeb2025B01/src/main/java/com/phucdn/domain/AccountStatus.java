package com.phucdn.domain;

public enum AccountStatus {
	PENDING_VERIFICATION, // ACC is created but not yet verified
	ACTIVE,	// ACC is active and in good standing
	SUSPENDED, // ACC is temp suspended, possibly due to violations
	DEACTIVATED,	// ACC is deactivated, user may have chosen to deactivate it
	BANNED,	// ACC is permanently banned due to servere violations
	CLOSED	// ACC is permanently closed, possibly at user request
}
