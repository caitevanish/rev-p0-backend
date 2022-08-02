package dev.evanishyn.services;

import dev.evanishyn.entities.Expense;

public interface ExpenseService {

    Expense createNewClaimService(Expense expense);

    Expense getAllClaimsService();

}
