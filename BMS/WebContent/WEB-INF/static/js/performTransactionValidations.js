function ValidateMyForm() {
	var accountNumber = document.myform.accountNumber.value;
	var customerName = document.myform.customerName.value;
	var transactionType = document.myform.transactionType.value;
	var transactionAmount = document.myform.transactionAmount.value;
	var description = document.myform.description.value;
	if (accountNumber.length != 16 || isNaN(accountNumber)) {
		alert("Account Number must be at least 16 digits long & numeric.");
		return false;
	} else if (!(transactionType == "Deposit" || transactionType == "Withdrawal")) {
		alert("Transaction Type should be Deposit or Withdrawal");
		return false;
	} else if (isNaN(transactionAmount)) {
		alert("Transaction Amount should be numeric");
		return false;
	} else if (description == null || description == "") {
		alert("Description can not be empty");
		return false;
	}
}
