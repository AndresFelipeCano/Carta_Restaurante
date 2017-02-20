package com.example.cano.carta_restaurante;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class localizanos extends FragmentActivity implements OnMapReadyCallback {
    //Se crearán varios marcadores para las distintas sedes del restaurante
    static final LatLng sedeMolinos= new LatLng(6.232976,-75.6038637);
    static final LatLng sedeLaureles=new LatLng(6.2450214,-75.5950574);
    static final LatLng sedeUnicentro=new LatLng(6.2407623,-75.5870117);
    static final LatLng sedeSandiego=new LatLng(6.2450214,-75.5950574);
    static final LatLng sedePremiumPlaza=new LatLng(6.2305039,-75.5781856);
    static final LatLng sedeEltesoro=new LatLng(6.1977843,-75.5596612);

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizanos);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng medellin=new LatLng(6.23775,-75.5798697);
        Marker sede1=mMap.addMarker(new MarkerOptions().position(sedeMolinos).draggable(false).title("Sede molinos").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        Marker sede2=mMap.addMarker(new MarkerOptions().position(sedeLaureles).draggable(false).title("Sede laureles").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        Marker sede3=mMap.addMarker(new MarkerOptions().position(sedeUnicentro).draggable(false).title("Sede unicentro").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        Marker sede4=mMap.addMarker(new MarkerOptions().position(sedeSandiego).draggable(false).title("Sede San Diego").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        Marker sede5=mMap.addMarker(new MarkerOptions().position(sedePremiumPlaza).draggable(false).title("Sede Premium Plaza").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        Marker sede6=mMap.addMarker(new MarkerOptions().position(sedeEltesoro).draggable(false).title("Sede El Tesoro").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        mMap.setMinZoomPreference(13);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(medellin));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                mMap.setMinZoomPreference(15);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(marker.getPosition()));
                mMap.resetMinMaxZoomPreference();
                return false;
            }
        });


    }
}
