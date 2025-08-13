| Classes     | Members                                                              | Methods                       | Scenarios           | Outputs            |
|-------------|----------------------------------------------------------------------|-------------------------------|---------------------|--------------------|
| Account     | Map<LocalDateTime, float> transactions, float balance, int accountId | deposit(float amount)         | amount > 0          | balance += amount  | 
|             |                                                                      |                               | amount < 0          | nothing happens    | 
|             |                                                                      | withdraw(float amount)        | amount < balance    | balance -= amount  | 
|             |                                                                      |                               | amount > balance    | nothing happens    | 
|             |                                                                      | getTransactions()             | has transactions    | List<Transactions> | 
|             |                                                                      |                               | no transactions     | null               |
|             |                                                                      | getBalance()                  |                     | balance            | 
|             |                                                                      | getAccountId()                |                     | accountId          |
|             |                                                                      | dtFormatter(LocalDateTime dt) | dt is LocalDateTime | String             |
| BankManager | List<Branch> branches                                                | allowOverdraft(Account acc)   | allow               | true               |
|             |                                                                      |                               | deny                | false              |
|             |                                                                      | getAccounts(Branch b)         | b has accounts      | b.getAccounts()    | 
|             |                                                                      |                               | b has no accounts   | null               | 
| Branch      | List<Accounts> accounts                                              | getAccounts()                 |                     | accounts           |



