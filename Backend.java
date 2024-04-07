import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class DepremUygulamasi {

    public static void main(String[] args) {
        SpringApplication.run(DepremUygulamasi.class, args);
    }

    @RestController
    @RequestMapping("/api/deprem")
    public class DepremController {

        // Deprem verilerini saklamak için bir servis
        private DepremServisi depremServisi;

        public DepremController(DepremServisi depremServisi) {
            this.depremServisi = depremServisi;
        }

        @PostMapping
        public void depremEkle(@RequestBody Deprem deprem) {
            depremServisi.depremEkle(deprem);
        }

        @GetMapping
        public List<Deprem> tumDepremler() {
            return depremServisi.tumDepremleriAl();
        }
    }

    // Deprem model sınıfı
    public class Deprem {

        private Long id;
        private Double lat;
        private Double lon;
        private Double siddet;

        // ... getter ve setter metotlar ...
    }

    // Deprem verileri ile ilgili işlemleri yapan servis
    public interface DepremServisi {

        void depremEkle(Deprem deprem);

        List<Deprem> tumDepremleriAl();
    }

    // ... DepremServisi implemetasyonu ...
}