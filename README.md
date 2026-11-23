# Project 1

### Description

Using Spring  Boot, create a REST Web App that simulates banking transactions.
### Requirements
- [ ]  Customers of the bank should be able to register with a username and password, and apply to open an account
- [ ] All interaction by the user should be done through the controller via HTTP Requests, following REST constraints
- [ ] Customers should be able to apply for joint accounts (share accounts with other users)
- [ ] Once the account is open, customers should be able to withdraw, deposit, and transfer funds between accounts.
	- [ ] All basic validation should be done, such as preventing users from trying to input negative amounts, overdrawing from accounts, etc.
- [ ] Employees of the bank should be able to view all of their customers' information. This includes: 
	- [ ] Account information
	- [ ] Account balances
	- [ ] Personal information 
	- [ ] Employees should also be able to approve/deny open applications for accounts
- [ ] Bank admins should be able to view and edit all accounts. This includes: 
	- [ ] Approving/denying accounts
	- [ ] Withdrawing
	- [ ] depositing
	- [ ] transferring from ALL accounts
	- [ ] Cancelling accounts
- [ ] Reasonable test coverage for the service layer is expected using JUnit 
	- [ ] TDD is encouraged
	- [ ] Aim for 80% coverage for the service layer

API testing should be done through Postman.
The repository layer should use entities and DTOs to prevent circular dependencies with Spring JPA