public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRecordRepository repo;

    public ClinicalAlertServiceImpl(ClinicalAlertRecordRepository r) {
        this.repo = r;
    }

    public ClinicalAlertRecord resolveAlert(Long id) {
        ClinicalAlertRecord a = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert"));
        a.setResolved(true);
        return repo.save(a);
    }

    public java.util.List<ClinicalAlertRecord> getAlertsByPatient(Long id) {
        return repo.findByPatientId(id);
    }

    public java.util.Optional<ClinicalAlertRecord> getAlertById(Long id) {
        return repo.findById(id);
    }

    public java.util.List<ClinicalAlertRecord> getAllAlerts() {
        return repo.findAll();
    }
}
