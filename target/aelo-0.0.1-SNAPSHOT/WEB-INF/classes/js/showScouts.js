$(document).ready(function()
		


{
$.get("/aelo/rest/scout/getAllScouts", function (data, textStatus)
		{
		var table = document.getElementById('presentationTable');
for(var i in data){
	
	var row = document.createElement("tr");
	var cellID = document.createElement("td");
	var cellIDText = document.createTextNode(data[i].idScout);
	
	var cellNotes = document.createElement("td");
	var cellNotesText = document.createTextNode(data[i].notes);
	
	var cellSoldier = document.createElement("td");
	var cellSoldierText = document.createTextNode(data[i].soldier.lastName + " " + data[i].soldier.rank);
	
	var cellVehicle = document.createElement("td");
	var cellVehicleText = document.createTextNode(data[i].vehicle.name + " " +data[i].vehicle.type);
	
	
	cellID.appendChild(cellIDText);
	cellNotes.appendChild(cellNotesText);
	cellSoldier.appendChild(cellSoldierText);
	cellVehicle.appendChild(cellVehicleText);
	

	var cellSelect = document.createElement("td");
	var cellSelectLink = document.createElement("a");
	var cellSelectPicture = document.createElement("img");
	cellSelectPicture.setAttribute('src', '/aelo/graphics/select.png');
	cellSelectLink.appendChild(cellSelectPicture);
	cellSelectLink.href = "../aelo/selectScout.html?id=" + data[i].idScout;
	cellSelect.appendChild(cellSelectLink);
	
	var cellUpdate = document.createElement("td");
	var cellUpdateLink = document.createElement("a");
	var cellUpdatePicture = document.createElement("img");
	cellUpdatePicture.setAttribute('src', '/aelo/graphics/update.png');
	cellUpdateLink.appendChild(cellUpdatePicture);
	cellUpdateLink.href = "../aelo/updateScout.html?id=" + data[i].idScout;
	cellUpdate.appendChild(cellUpdateLink);

	var cellDelete = document.createElement("td");
	var cellDeleteLink = document.createElement("a");
	var cellDeletePicture = document.createElement("img");
	cellDeletePicture.setAttribute('src', '/aelo/graphics/delete2.png');
	cellDeleteLink.appendChild(cellDeletePicture);
	cellDeleteLink.href = "../aelo/deleteScout.html?id=" + data[i].idScout;
	cellDelete.appendChild(cellDeleteLink);
	
	
	row.appendChild(cellID);
	row.appendChild(cellNotes);
	row.appendChild(cellSoldier);
	row.appendChild(cellVehicle);
	row.appendChild(cellSelect);
	row.appendChild(cellUpdate);
	row.appendChild(cellDelete);
	table.appendChild(row);
}



});













});




