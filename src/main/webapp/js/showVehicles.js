$(document).ready(function()
		


{
$.get("/aelo/rest/vehicle/getAllVehicles", function (data, textStatus)
		{
		var table = document.getElementById('presentationTable');
for(var i in data){
	
	var row = document.createElement("tr");
	var cellID = document.createElement("td");
	var cellIDText = document.createTextNode(data[i].idVehicle);
	
	var cellName = document.createElement("td");
	var cellNameText = document.createTextNode(data[i].name);
	
	var cellType = document.createElement("td");
	var cellTypeText = document.createTextNode(data[i].type);
	
	var cellSpeed = document.createElement("td");
	var cellSpeedText = document.createTextNode(data[i].speed);
	
	
	cellID.appendChild(cellIDText);
	cellName.appendChild(cellNameText);
	cellType.appendChild(cellTypeText);
	cellSpeed.appendChild(cellSpeedText);
	
	var cellRead = document.createElement("td");
	var cellReadLink = document.createElement("a");
	var cellReadPicture = document.createElement("img");
	cellReadPicture.setAttribute('src', '/aelo/graphics/select.png');
	cellReadLink.appendChild(cellReadPicture);
	cellReadLink.href = "../aelo/selectVehicle.html?id=" + data[i].idVehicle;
	cellRead.appendChild(cellReadLink);
	
	var cellUpdate = document.createElement("td");
	var cellUpdateLink = document.createElement("a");
	var cellUpdatePicture = document.createElement("img");
	cellUpdatePicture.setAttribute('src', '/aelo/graphics/update.png');
	cellUpdateLink.appendChild(cellUpdatePicture);
	cellUpdateLink.href = "../aelo/updateVehicle.html?id=" + data[i].idVehicle;
	cellUpdate.appendChild(cellUpdateLink);

	var cellDelete = document.createElement("td");
	var cellDeleteLink = document.createElement("a");
	var cellDeletePicture = document.createElement("img");
	cellDeletePicture.setAttribute('src', '/aelo/graphics/delete2.png');
	cellDeleteLink.appendChild(cellDeletePicture);
	cellDeleteLink.href = "../aelo/deleteVehicle.html?id=" + data[i].idVehicle;
	cellDelete.appendChild(cellDeleteLink);
	
	
	
	row.appendChild(cellID);
	row.appendChild(cellName);
	row.appendChild(cellType);
	row.appendChild(cellSpeed);
	row.appendChild(cellRead);
	row.appendChild(cellUpdate);
	row.appendChild(cellDelete);
	table.appendChild(row);
}



});













});




