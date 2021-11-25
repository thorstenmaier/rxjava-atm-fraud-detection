# ATM Fraud detection with RxJava

People often ask me about use cases for reactive programming. This is usually not easy and quickly explained, as the
benefits of reactive programming are only fully realized in a completely reactive environment. Minimal code examples
that are easy to follow often fail to explain this environment.

This repository contains a reactive pipeline that can be traced quite quickly. It is about detecting fraud at ATMs.
Let's say we have a data stream that includes all ATM transactions that are processed through a bank or credit card
company. How can we detect fraud attempts in that case?

It is very likely to be a fraud attempt if money is withdrawn with one card number at two different ATMs within a short
period of time and these ATMs are far enough apart so that it is not possible to travel between these two ATMs in the
time between the two transactions.

## Transaction generator

The method `Transactions.getAtmTransactions(...)` is able to generate a continuous
stream of transactions with random transaction data.