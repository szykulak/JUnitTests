package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {

    private Person CEO;
    private Person CTO;
    private Person CFO;
    private List<Localisation> localisationList;

    public Company(Person CEO, Person CTO, Person CFO) {
        this.CEO = CEO;
        this.CTO = CTO;
        this.CFO = CFO;
        this.localisationList = new ArrayList<Localisation>();
    }

    public int countEmployees() {
        int sum = 0;
        for (Localisation loc : localisationList) {
            for (Department dept : loc.getDepartmentList()) {
                sum += dept.getPersonList().size();
            }
        }
        return sum;
    }

    public void addLocalisation(Localisation localisation) {

        if (localisationList.contains(localisation)) {
            throw new IllegalArgumentException("Localisation already exists");
        } else {
            localisationList.add(localisation);
        }

    }

    public void removeLocalisation(Localisation localisation) {

        localisationList.remove(localisation);

    }

    public Person getCEO() {
        return CEO;
    }

    public void setCEO(Person CEO) {
        this.CEO = CEO;
    }

    public Person getCTO() {
        return CTO;
    }

    public void setCTO(Person CTO) {
        this.CTO = CTO;
    }

    public Person getCFO() {
        return CFO;
    }

    public void setCFO(Person CFO) {
        this.CFO = CFO;
    }

    public List<Localisation> getLocalisationList() {
        return localisationList;
    }

    public void setLocalisationList(List<Localisation> localisationList) {
        this.localisationList = localisationList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(CEO, company.CEO) &&
                Objects.equals(CTO, company.CTO) &&
                Objects.equals(CFO, company.CFO) &&
                Objects.equals(localisationList, company.localisationList);
    }

    @Override
    public String toString() {
        return "Company{" +
                "CEO=" + CEO +
                ", CTO=" + CTO +
                ", CFO=" + CFO +
                ", localisationList=" + localisationList +
                '}';
    }
}
