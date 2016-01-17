$(document).ready(function()
		


{
$.get("/aelo/rest/soldier/getAllSoldiers", function (data, textStatus)
		{
		var table = document.getElementById('presentationTable');
for(var i in data){
	
	var row = document.createElement("tr");
	var cellID = document.createElement("td");
	var cellIDText = document.createTextNode(data[i].idSoldier);
	
	var cellFirstName = document.createElement("td");
	var cellFirstNameText = document.createTextNode(data[i].firstName);
	
	var cellLastName = document.createElement("td");
	var cellLastNameText = document.createTextNode(data[i].lastName);
	
	var cellRank = document.createElement("td");
	var cellRankText = document.createTextNode(data[i].rank);
	
	
	cellID.appendChild(cellIDText);
	cellFirstName.appendChild(cellFirstNameText);
	cellLastName.appendChild(cellLastNameText);
	cellRank.appendChild(cellRankText);
	
	var cellRead = document.createElement("td");
	var cellReadLink = document.createElement("a");
	var cellReadPicture = document.createElement("img");
	cellReadPicture.setAttribute('src', '/aelo/graphics/select.png');
	cellReadLink.appendChild(cellReadPicture);
	cellReadLink.href = "../aelo/selectSoldier.html?id=" + data[i].idSoldier;
	cellRead.appendChild(cellReadLink);
	
	var cellUpdate = document.createElement("td");
	var cellUpdateLink = document.createElement("a");
	var cellUpdatePicture = document.createElement("img");
	cellUpdatePicture.setAttribute('src', '/aelo/graphics/update.png');
	cellUpdateLink.appendChild(cellUpdatePicture);
	cellUpdateLink.href = "../aelo/updateSoldier.html?id=" + data[i].idSoldier;
	cellUpdate.appendChild(cellUpdateLink);

	var cellDelete = document.createElement("td");
	var cellDeleteLink = document.createElement("a");
	var cellDeletePicture = document.createElement("img");
	cellDeletePicture.setAttribute('src', '/aelo/graphics/delete2.png');
	cellDeleteLink.appendChild(cellDeletePicture);
	cellDeleteLink.href = "../aelo/deleteSoldier.html?id=" + data[i].idSoldier;
	cellDelete.appendChild(cellDeleteLink);
	
	
	
	row.appendChild(cellID);
	row.appendChild(cellFirstName);
	row.appendChild(cellLastName);
	row.appendChild(cellRank);
	row.appendChild(cellRead);
	row.appendChild(cellUpdate);
	row.appendChild(cellDelete);
	table.appendChild(row);
}



});













});




