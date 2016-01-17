$(document).ready(function()
{
    var id = window.location.search.replace("?id=", "");

    document.getElementById('idScoutId').value = id;


    $.get("/aelo/rest/soldier/getAllSoldiers", function(data, textStatus)
    	    {
    	       var soldierSelect = document.getElementById('soldierId');

    	       for(var i in data) {
    	            var opt = document.createElement('option');

    	            var sol = data[i].idSoldier+ ": " + data[i].lastName + " " + data[i].rank;

    	            opt.value = sol;
    	            opt.innerHTML = sol;
    	            soldierSelect.appendChild(opt);
    	       }
    	    });

    	  
    	    $.get("/aelo/rest/vehicle/getAllVehicles", function(data, textStatus)
    	    {
    	       var vehicleSelect = document.getElementById('vehicleId');

    	       for(var i in data) {
    	            var opt = document.createElement('option');

    	            var veh = data[i].idVehicle + ": "+data[i].name + " " + data[i].type;

    	            opt.value = veh;
    	            opt.innerHTML = veh;
    	            vehicleSelect.appendChild(opt);
    	       }
    	    });

    
    $.get("/aelo/rest/scout/getScout/" + id, function(data, textStatus)
    {
       document.getElementById('id').innerHTML = data.idScout;
       

      
       document.getElementById('sodlierId').value = data.sodlier.idSoldier + ": " + data.sodlier.lastName + " " + data.sodlier.rankName;
       document.getElementById('vehicleId').value = data.vehicle.idVehicle + ": " + data.vehicle.name + " " + data.vehicle.type;
       
    });
});