$(document).ready(function()
{
    var id = window.location.search.replace("?id=", "");

 

    $.get("/aelo/rest/soldier/getSoldier/" + id, function(data, textStatus)
    {
       document.getElementById('id').innerHTML = data.idSoldier;
       document.getElementById('firstName').innerHTML = data.firstName;
       document.getElementById('lastName').innerHTML = data.lastName;
       document.getElementById('rank').innerHTML = data.rank;
    });
});