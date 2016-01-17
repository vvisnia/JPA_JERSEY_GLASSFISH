$(document).ready(function()
{
    var id = window.location.search.replace("?id=", "");

    document.getElementById('idScoutId').value = id;

    $.get("/aelo/rest/scout/getScout/" + id, function(data, textStatus)
    {
       document.getElementById('id').innerHTML = data.idScout;
       document.getElementById('notes').innerHTML = data.notes;
       document.getElementById('soldier').innerHTML = data.soldier.lastName + " " + data.soldier.rank;
       document.getElementById('vehicle').innerHTML = data.vehicle.name + " " + data.vehicle.type;
 
    });
});