package com.springbootsauna.springbootsaunarestapi.util;

public enum EAppointmentStatus {
    CUSTOMER_SUBMITTED,

    RECEPTIONIST_PENDING,
    RECEPTIONIST_APPROVED,
    RECEPTIONIST_REJECTED,

    MASSEUR_APPROVED,
    MASSEUR_REJECTED,
    MASSEUR_RECOMMEND,

    MANAGER_APPROVED,
    MANAGER_REJECTED,

    OWNER_APPROVED,
    OWNER_REJECTED
}
