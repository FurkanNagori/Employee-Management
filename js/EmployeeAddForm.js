function validateForm(frm)
{
var firstInvalidComponent=null;
var valid=true;
var name = frm.name.value.trim();
var nameErrorSection = document.getElementById('nameErrorSection');
nameErrorSection.innerHTML='';
if(name.length==0)
{
nameErrorSection.innerHTML='name required';
valid=false;
firstInvalidComponent=frm.name;
}

var designationCode = frm.designationCode.value;
var designationCodeErrorSection = document.getElementById('designationCodeErrorSection');
designationCodeErrorSection.innerHTML='';
if(designationCode==-1)
{
designationCodeErrorSection.innerHTML='select designation';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.designationCode;
}

var dateOfBirth = frm.dateOfBirth.value;
var dateOfBirthErrorSection = document.getElementById('dateOfBirthErrorSection');
dateOfBirthErrorSection.innerHTML='';
if(dateOfBirth.length==0)
{
dateOfBirthErrorSection.innerHTML='select date of birth';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.dateOfBirth;
}


var genderErrorSection = document.getElementById('genderErrorSection');
genderErrorSection.innerHTML='';
if(frm.gender[0].checked==false && frm.gender[1].checked==false)
{
genderErrorSection.innerHTML='select gender';
valid=false;
}

var basicSalary = frm.basicSalary.value.trim();
var basicSalaryErrorSection = document.getElementById('basicSalaryErrorSection');
basicSalaryErrorSection.innerHTML='';
if(basicSalary.length==0)
{
basicSalaryErrorSection.innerHTML='basic salary required';
valid=false;

if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;
}
else
{

//var v ='0123456789.';
//var e=18;
var isBasicSalaryValid = true;
/*while(e<basicSalary.length)
{
alert("loop me gaya");
if(v.indexOf(basicSalary.chatAt(e))==-1)
{
alert("if me gaya");
basicSalaryErrorSection.innerHTML='invalid basic salary';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;
isBasicSalaryValid=false;

break;
}
alert("loop me hi hai");
e++;
}
*/
if(isBasicSalaryValid)
{
var dot =basicSalary.indexOf('.');
if(dot!=-1)
{
var numberOfFraction = basicSalary.length-(dot+1);
if(numberOfFraction>2)
{
basicSalaryErrorSection.innerHTML='invalid basic salary';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;
}
}
}
}
var panNumber = frm.panNumber.value.trim();
var panNumberErrorSection = document.getElementById('panNumberErrorSection');
panNumberErrorSection.innerHTML='';
if(panNumber.length==0)
{
panNumberErrorSection.innerHTML='pan number required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.panNumber;
}

var aadharCardNumber = frm.aadharCardNumber.value.trim();
var aadharCardNumberErrorSection = document.getElementById('aadharCardNumberErrorSection');
aadharCardNumberErrorSection.innerHTML='';
if(aadharCardNumber.length==0)
{
aadharCardNumberErrorSection.innerHTML='aadhar number required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.aadharCardNumber;
}


if(!valid) firstInvalidComponent.focus();
return valid;
}

