$(document).ready(function()
{
    var id = window.location.search.replace("?id=", "");

    document.getElementById('idVehicleId').value = id;

    $.get("/aelo/rest/vehicle/getVehicle/" + id, function(data, textStatus)
    {
       document.getElementById('id').innerHTML = data.idVehicle;
       document.getElementById('name').innerHTML = data.name;
       document.getElementById('type').innerHTML = data.type;
       document.getElementById('speed').innerHTML = data.speed;
    });
});