public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository logRepo;
    private final PatientProfileRepository patientRepo;
    private final RecoveryCurveService rc;
    private final DeviationRuleService dr;
    private final ClinicalAlertService ca;

    public DailySymptomLogServiceImpl(
            DailySymptomLogRepository l,
            PatientProfileRepository p,
            RecoveryCurveService rc,
            DeviationRuleService dr,
            ClinicalAlertService ca) {
        this.logRepo = l; this.patientRepo = p;
        this.rc = rc; this.dr = dr; this.ca = ca;
    }

    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {
        patientRepo.findById(log.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient"));

        logRepo.findByPatientIdAndLogDate(log.getPatientId(), log.getLogDate())
                .ifPresent(x -> { throw new IllegalArgumentException("Duplicate"); });

        return logRepo.save(log);
    }

    public DailySymptomLog updateSymptomLog(Long id, DailySymptomLog updated) {
        DailySymptomLog existing = logRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log"));

        patientRepo.findById(existing.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient"));

        updated.setPatientId(existing.getPatientId());
        return logRepo.save(updated);
    }

    public java.util.List<DailySymptomLog> getLogsByPatient(Long pid) {
        patientRepo.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Patient"));
        return logRepo.findByPatientId(pid);
    }
}
