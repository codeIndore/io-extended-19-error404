import java.util.*;

val Withdrawl =1
val Deposit= 2
val Ministatement=3
val DisplayAmount=4
val Exit=5
var userChoice: Int= Withdrawl
var homeChoice: Int = 1;
fun main(args: Array<String>)
{
	println("***** Welcome to the Bank *****")
	
	var bank: Bank = Bank()
	do{
	doHomeScreenAction(bank)
	//doBankActionFromUserInput(bank)
	}while(homeChoice!=3)
		println()
	println("***** Thank you!!! *****")
}	
	
fun homeScreen()
{
	println()
	println("Choose any one")
	println("1: Register")
	println("2: Login")
	println("3: Exit")
}
		
fun greetUserWithChoice()
{		
		println()
		println("Choose from the below options:")
		println("1: Withdrawl")
		println("2: Deposite")
		println("3: Ministatement")
		println("4: Display Amount")
		println("5: Exit")
}
	
	
fun getDepositeAmountFromUser():Double
{
		print("Add amount to Deposit :- ")
		val depositeAmount= readLine()!!.toDouble()
		return depositeAmount 
}
	
fun getWithdrawlAmountFromUser():Double
{
		print("Enter amount to Withdraw :- ")
		val WithdrawlAmount= readLine()!!.toDouble()
		return WithdrawlAmount 
}

fun doBankActionFromUserInput(bank: Bank, accNum: String)
{		
	do
	{
		greetUserWithChoice()
		userChoice=readLine()!!.toInt()
		if(userChoice==Deposit)
		{
			var depositAmount= getDepositeAmountFromUser()
			bank.deposit(depositAmount,accNum)
			println("Date: ${bank.getCurrentDate(System.currentTimeMillis())}")
		}
		else if(userChoice==Withdrawl)
		{
			var WithdrawlAmount= getWithdrawlAmountFromUser()
			bank.withdrawl(WithdrawlAmount,accNum)
		}
		else if(userChoice==Ministatement)
		{
			bank.showMinistatement(accNum)
		}
		else if(userChoice==DisplayAmount)
		{
			bank.showBalance(accNum)
		}
	}while(userChoice!=Exit)
}

fun doHomeScreenAction(bank: Bank)
{
	homeScreen()
	homeChoice=readLine()!!.toInt()
		if(homeChoice==1)
		{
			print("Enter your Name :-")
			var name= readLine()!!.toString()
			print("Enter your Account Number :-")
			var accNum = readLine()!!.toString()
			print("Enter your Password :-")
			var password= readLine()!!.toString()
			print("Enter your Mobile Number :-")
			var mob= readLine()!!.toString()
			var amount: Double= 0.0
			bank.registration(name,accNum,password,mob,amount)
		}
		else if(homeChoice==2)
		{
			print("Enter your Account Number :-")
			var accNum = readLine()!!.toString()
			print("Enter your Password :-")
			var password= readLine()!!.toString()
			if(bank.checkLogin(accNum,password))
			{
				doBankActionFromUserInput(bank,accNum)
			}
			else{
				println("Invalid User!!!")
			}
			
		}
		
}

