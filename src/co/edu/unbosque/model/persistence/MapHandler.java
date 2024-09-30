package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Mascota;

public class MapHandler {

	public static Mascota convertirMascotaDTOtoMascota(MascotaDTO mDTO) {
        Mascota x = new Mascota(mDTO.getNombre(), mDTO.getTipo(), mDTO.getEdad());
        return x;
    }

    public static MascotaDTO convertirMascotatoMascotaDTO(Mascota m) {
        MascotaDTO x = new MascotaDTO(); // es el contructor por defecto de una clase que NO tiene constructor, por
                                            // transportar informacion no se crea el constructor
        x.setNombre(m.getNombre());
        x.setTipo(m.getTipo());
        x.setEdad(m.getEdad());
        return x;
    }

    public static ArrayList<Mascota> convertirVeterinariaDTOtoVeterinaria(ArrayList<MascotaDTO> vDTO) {
        ArrayList<Mascota> x = new ArrayList<Mascota>();
        for (MascotaDTO mDTO : vDTO) {
            Mascota aux = convertirMascotaDTOtoMascota(mDTO);
            x.add(aux);
        }
        return x;
    }
    
    public static ArrayList<MascotaDTO> convertirVeterinariatoVeterinariaDTO(ArrayList<Mascota> m) {
        ArrayList<MascotaDTO> x = new ArrayList<MascotaDTO>();
        for (Mascota mas : m) {
            MascotaDTO aux = convertirMascotatoMascotaDTO(mas);
            x.add(aux);
        }
        return x;
    }
}
