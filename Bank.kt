import java.text.SimpleDateFormat
import java.util.*
import java.io.File
import java.io.BufferedReader
import java.io.FileReader

class Bank() {
	//var userInfo = "src/userInfo/yash.txt"
	//var miniStatements = "src/miniStatements/yashStatements.txt"
	
	
	var moneyInBank: Double= 0.0
	
	fun deposit(amount : Double, accNum: String)
	{
		var fileName ="src/userInfo/" + accNum + ".txt"
		var lines: List<String> = File(fileName).readLines()
		var input = lines[0].split(",")
		moneyInBank = input[4].toDouble()
		moneyInBank += amount
		var moneyString = moneyInBank.toString()
		var inputData : String = input[0] +","+ input[1] +","+ input[2] +","+ input[3] +","+ moneyString
		var file = File(fileName)
		file.writeText(inputData)
		
		var miniStatementFile = "src/ministatements/"+accNum + ".txt"
		var minifile = File(miniStatementFile)
 
		var fileExists = minifile.exists()
 
		if(fileExists){
			var lines: List<String> = File(miniStatementFile).readLines()
			var linkedList = LinkedList(lines)
				linkedList.push("Deposite on\t"+getCurrentDate(System.currentTimeMillis())+"\t Ammount  +"+amount)
			var final: String = linkedList.joinToString()
			minifile.writeText(final)
	
			//lines.forEach { line -> println(line) }
		} else {
			minifile.createNewFile()
			minifile.writeText("Deposite on\t"+getCurrentDate(System.currentTimeMillis())+"\t Ammount  +"+amount)
		}
		println("Deposite Successfull!!")
	}
	
	fun <T> linkedListOf(vararg elements: T): LinkedList<T> {
    return LinkedList<T>(elements.toList())
	}
	
	
	fun withdrawl(amount : Double, accNum: String)
	{
		var fileName ="src/userInfo/" + accNum + ".txt"
		var lines: List<String> = File(fileName).readLines()
		var input = lines[0].split(",")
		moneyInBank = input[4].toDouble()
		if(moneyInBank>=amount)
		{
				moneyInBank -= amount
				var moneyString = moneyInBank.toString()
				var inputData : String = input[0] +","+ input[1] +","+ input[2] +","+ input[3] +","+ moneyString
				var file = File(fileName)
				file.writeText(inputData)
			
				var miniStatementFile = "src/ministatements/"+accNum + ".txt"
				var minifile = File(miniStatementFile)
 
				var fileExists = minifile.exists()
		
				if(fileExists){
					var lines: List<String> = File(miniStatementFile).readLines()
					var linkedList = LinkedList(lines)
					linkedList.push("Withdraw on\t"+getCurrentDate(System.currentTimeMillis())+"\t Ammount  -"+amount)
					var final: String = linkedList.joinToString()
					minifile.writeText(final)
				
			//lines.forEach { line -> println(line) }
				} else {
					minifile.createNewFile()
					minifile.writeText("Withdraw on\t"+getCurrentDate(System.currentTimeMillis())+"\t Ammount  -"+amount)
		}
		println("Withdraw Successfull!!")
		}
		else
		{
			println("Insufficient Balace")
		}
		
	}
	
	fun getCurrentDate(CurrentTimeinMillisecond: Long): String
	{	
		val date= Date(CurrentTimeinMillisecond)
		val formatter= SimpleDateFormat("MMM/dd/y: h:mm:a")
		return formatter.format(date)
	}
	
	fun showMinistatement(accNum: String)
	{
		var miniStatementFile = "src/ministatements/"+accNum + ".txt"
		var lines: List<String> = File(miniStatementFile).readLines()
		var input = lines[0].split(",")
		input.forEach { input -> println(input) }
		println("---------------------------------------------------------------")
		print("\t\t\t")
		showBalance(accNum)
	}
	
	fun showBalance(accNum: String) 
	{
		var fileName ="src/userInfo/" + accNum + ".txt"
		var lines: List<String> = File(fileName).readLines()
		var input = lines[0].split(",")
		moneyInBank = input[4].toDouble()
		println("Available Balance is "+moneyInBank)
	}
	
/*	fun transferBalance(sender: String, receiver: String, amount: Double)
	{
		var fileName ="src/userInfo/" + sender + ".txt"
		var lines: List<String> = File(fileName).readLines()
		var input = lines[0].split(",")
		moneyInBank = input[4].toDouble()
		if(moneyInBank>=amount)
		{
				moneyInBank -= amount
				var moneyString = moneyInBank.toString()
				var inputData : String = input[0] +","+ input[1] +","+ input[2] +","+ input[3] +","+ moneyString
				var file = File(fileName)
				file.writeText(inputData)
			
				var miniStatementFile = "src/ministatements/"+sender + ".txt"
				var minifile = File(miniStatementFile)
 
				var fileExists = minifile.exists()
		
				if(fileExists){
					var lines: List<String> = File(miniStatementFile).readLines()
					var linkedList = LinkedList(lines)
					linkedList.push("Transfered to\t "+receiver+"\t"+getCurrentDate(System.currentTimeMillis())+"\t Ammount  -"+amount)
					var final: String = linkedList.joinToString()
					minifile.writeText(final)
	
			//lines.forEach { line -> println(line) }
				} else {
					minifile.createNewFile()
					minifile.writeText("Transfered to\t "+receiver+"\t"+getCurrentDate(System.currentTimeMillis())+"\t Ammount  -"+amount)
		}
		}
		else
		{
			println("Insufficient Balace")
		}
		
		var receiverfileName ="src/userInfo/" + sender + ".txt"
		var receiverlines: List<String> = File(receiverfileName).readLines()
		var receiverinput = receiverlines[0].split(",")
		var receivermoneyInBank = input[4].toDouble()
		var receiverinput = lines[0].split(",")
		moneyInBank = receiverinput[4].toDouble()
		moneyInBank += amount
		var moneyString = moneyInBank.toString()
		var inputData : String = input[0] +","+ input[1] +","+ input[2] +","+ input[3] +","+ moneyString
		var file = File(fileName)
		file.writeText(inputData)
		
		var miniStatementFile = "src/ministatements/"+accNum + ".txt"
		var minifile = File(miniStatementFile)
 
		var fileExists = minifile.exists()
 
		if(fileExists){
			var lines: List<String> = File(miniStatementFile).readLines()
			var linkedList = LinkedList(lines)
				linkedList.push("Deposite on\t"+getCurrentDate(System.currentTimeMillis())+"\t Ammount  +"+amount)
			var final: String = linkedList.joinToString()
			minifile.writeText(final)
	
			//lines.forEach { line -> println(line) }
		} else {
			minifile.createNewFile()
			minifile.writeText("Deposite on\t"+getCurrentDate(System.currentTimeMillis())+"\t Ammount  +"+amount)
		}
	}
*/	
	
	fun registration(name : String,accNum : String, pass: String, mob: String, amount: Double)
	{
		var data: String = name + "," + accNum + "," + pass + "," + mob +"," + amount.toString()
		var fileName = accNum + ".txt"
		var file = File("src/userInfo/"+fileName)
		val isNewFileCreated :Boolean = file.createNewFile()
		file.writeText(data)
		if(isNewFileCreated){
			println("Account created successfully.")
		} else{
			println("Account number already exists.")
		}
	}
	
	
	fun checkLogin(accNum: String, pass: String): Boolean
	{
		try{
		var fileName ="src/userInfo/" + accNum + ".txt"
		var lines: List<String> = File(fileName).readLines()
		var input = lines[0].split(",")
		if(input[2].equals(pass))
			return true
		else
			return false
		}catch(er : Exception)
				{
					return false
				}
	}
}