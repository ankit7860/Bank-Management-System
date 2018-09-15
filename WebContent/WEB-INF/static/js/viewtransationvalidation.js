/**
 * this is javascript file for viewTransaction validation jsp page
 */

function ValidateMyForm() {
	var accountNumber = document.viewform.accountNumber.value;
	var transactionId = document.viewform.transactionId.value;
	if (accountNumber.length != 16 && accountNumber.length != 0) {
		alert("Account Number must be at least 16 digits long.");
		return false;
	} else if (transactionId.length != 10 && transactionId != 0) {
		alert("Transaction Id must be at least 10 characters long.");
		return false;
	} 
}
