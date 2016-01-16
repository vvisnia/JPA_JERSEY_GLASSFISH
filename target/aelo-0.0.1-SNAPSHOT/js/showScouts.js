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
	

	
	
	
	row.appendChild(cellID);
	row.appendChild(cellNotes);
	row.appendChild(cellSoldier);
	row.appendChild(cellVehicle);

	table.appendChild(row);
}



});













});




