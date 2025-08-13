| Classes        | Members                                                              | Methods                       | Scenarios           | Outputs            |
|----------------|----------------------------------------------------------------------|-------------------------------|---------------------|--------------------|
| Account        | Map<LocalDateTime, float> transactions, float balance, int accountId | deposit(float amount)         | amount > 0          | balance += amount  | 
|                |                                                                      |                               | amount < 0          | nothing happens    | 
|                |                                                                      | withdraw(float amount)        | amount < balance    | balance -= amount  | 
|                |                                                                      |                               | amount > balance    | nothing happens    | 
|                |                                                                      | getTransactions()             | has transactions    | List<Transactions> | 
|                |                                                                      |                               | no transactions     | null               |
|                |                                                                      | getBalance()                  |                     | this.balance       | 
|                |                                                                      | getAccountId()                |                     | this.accountId     |
|                |                                                                      | dtFormatter(LocalDateTime dt) | dt is LocalDateTime | String             |
|                |                                                                      | toString()                    |                     | this.toString()    |
| SavingsAccount |                                                                      |                               |                     |                    | 
| CurrentAccount |                                                                      |                               |                     |                    |
| BankManager    | List<Branch> branches                                                | allowOverdraft(Account acc)   | allow               | true               |
|                |                                                                      |                               | deny                | false              |
|                |                                                                      | getAccounts(Branch b)         | b has accounts      | b.getAccounts()    | 
|                |                                                                      |                               | b has no accounts   | null               | 
| Branch         | List<Accounts> accounts                                              | getAccounts()                 |                     | this.accounts      |
|                |                                                                      | addAccount(Account a)         |                     | void               |
| Transaction    | String time, float amount, String type, int transactionId            | getType()                     |                     | int                | 
|                |                                                                      | getAmount()                   |                     | float              | 
|                |                                                                      | getTransactionId()            |                     | int                | 
|                |                                                                      | getTime()                     |                     | String             | 





