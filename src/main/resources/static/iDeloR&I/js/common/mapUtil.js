function initMap() {
    var map;
    var markers = [];

    //Tallinn for now
    var startLocation = new google.maps.LatLng(59.4426896, 24.75319719999993);
    var mapOptions = {
        zoom: 10,
        center: startLocation,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);

    google.maps.event.addListener(map, "click", function (event) {
        placeMarker(event.latLng, map, markers);
        $("#latFld").val(event.latLng.lat());
        $("#lngFld").val(event.latLng.lng());
    });
}

function placeMarker(chosenLocation, map, markers) {
    deleteOverlays(markers);

    var marker = new google.maps.Marker({
        position: chosenLocation,
        map: map
    });
    markers.push(marker);
}

function deleteOverlays(marker) {
    if (marker) {
        for (i in marker) {
            marker[i].setMap(null);
        }
        marker.length = 0;
    }
}

function initDisplayMap(lat, lng) {
    var map;
    //Tallinn for now
    var startLocation = new google.maps.LatLng(lat, lng);
    var mapOptions = {
        zoom: 10,
        center: startLocation,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);

    var marker = new google.maps.Marker({
        position: startLocation,
        map: map
    });
}