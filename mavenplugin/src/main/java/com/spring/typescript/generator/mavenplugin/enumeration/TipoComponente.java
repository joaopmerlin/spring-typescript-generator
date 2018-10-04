package com.spring.typescript.generator.mavenplugin.enumeration;

public enum TipoComponente {

    INPUT_TEXT("import {InputTextModule} from 'primeng/inputtext'", "InputTextModule"),
    INPUT_NUMBER("import {InputTextModule} from 'primeng/inputtext'", "InputTextModule"),
    CALENDAR("import {CalendarModule} from 'primeng/calendar'", "CalendarModule"),
    DROPDOWN("import {DropdownModule} from 'primeng/dropdown'", "DropdownModule"),
    MULTI_SELECT("import {MultiSelectModule} from 'primeng/multiselect'", "MultiSelectModule"),
    CHECKBOX("import {CheckboxModule} from 'primeng/checkbox'", "CheckboxModule");

    private String primeImport;
    private String primeModule;

    TipoComponente(String primeImport, String primeModule) {
        this.primeImport = primeImport;
        this.primeModule = primeModule;
    }

    public String getPrimeImport() {
        return primeImport;
    }

    public String getPrimeModule() {
        return primeModule;
    }
}
