

var input_dir = document.getElementById("dir");
var input_city = document.getElementById("ciudad");
var input_prov = document.getElementById("prov");
var input_lat = document.getElementById("lat");
var input_lng = document.getElementById("lng");
var sb = document.getElementById("pac-input");

var btn_add = document.getElementById("add_dir");
var btn_close = document.getElementById("close_modal");

// Creamos Search Box y lo linkeamos al input
var input = document.getElementById("pac-input");

var map;
var lat;
var lng;

let geocoder;






function initAutocomplete() {

    map = new google.maps.Map(document.getElementById("map"), {
        center: { lat: -34.668544, lng: -58.5531392 },
        zoom: 15,
        disableDefaultUI: true,
        mapTypeId: 'roadmap'
    });

    setMap();
    geocoder = new google.maps.Geocoder();

    btn_add.addEventListener("click", function (){
        geocodeLatLng(geocoder);
        btn_close.click();
    });



}

function initInverseAutocomplete() {
   map = new google.maps.Map(document.getElementById("map"), {
        center: { lat: parseFloat(input_lat.value), lng: parseFloat(input_lng.value) },
        zoom: 15,
        disableDefaultUI: true,
        mapTypeId: 'roadmap'
    });

    setMap();
}

function setMap(){
    var searchBox = new google.maps.places.SearchBox(input);



    // mostramos los resultados del Search Box en el mapa
    map.addListener("bounds_changed", function () {
        searchBox.setBounds(map.getBounds());
        var pos = map.getBounds();
        navigator.geolocation.getCurrentPosition(function (position){
            // input_lat.value = position.coords.latitude;

        });

    });

    var markers = [];
    // Listen for the event fired when the user selects a prediction and retrieve
    // more details for that place.
    searchBox.addListener("places_changed", function () {
        var places = searchBox.getPlaces();
        if (places.length == 0) {
            return;
        }
        // Clear out the old markers.
        markers.forEach(function (marker) {
            marker.setMap(null);
        });
        btn_add.setAttribute("disabled", true);
        markers = [];
        // For each place, get the icon, name and location.
        // @ts-ignore
        var bounds = new google.maps.LatLngBounds();
        //console.log(map.getBounds());
        //console.log(bounds);
        places.forEach(function (place) {
            if (!place.geometry || !place.geometry.location) {
                // console.log("Returned place contains no geometry");
                btn_add.setAttribute("disabled", true);
                return;
            }
            // @ts-ignore
            var icon = {
                url: place.icon,
                size: new google.maps.Size(71, 71),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(30, 30)
            };
            // Create a marker for each place.
            // @ts-ignore
            markers.push(
                new google.maps.Marker({
                    map: map,
                    icon: icon,
                    title: place.name,
                    position: place.geometry.location
                }));
            if (place.geometry.viewport) {
                // Only geocodes have viewport.
                bounds.union(place.geometry.viewport);
            }
            else {
                bounds.extend(place.geometry.location);
            }
            lat = place.geometry.location.lat();
            lng = place.geometry.location.lng();
            btn_add.removeAttribute("disabled");






        });

        map.zoom = 15;
        map.fitBounds(bounds);






    });
}

function geocodeLatLng(geocoder) {

    const latlng = {
        lat: parseFloat(lat),
        lng: parseFloat(lng),
    };

    geocoder
        .geocode({ location: latlng })
        .then((response) => {
            if (response.results[0]) {

                console.log(response.results[0]);
                input_dir.value = response.results[0].formatted_address;
                input_city.value = response.results[0].address_components[2].long_name;
                input_prov.value = response.results[0].address_components[4].long_name;
                input_lat.value = lat;
                input_lng.value = lng;

            } else {
                console.log("No results found");
            }
        })
        .catch((e) => console.log("Geocoder failed due to: " + e));
}



window.initAutocomplete = initAutocomplete;

