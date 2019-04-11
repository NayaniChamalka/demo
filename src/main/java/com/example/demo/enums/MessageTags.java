package com.example.demo.enums;

public enum MessageTags implements EnumType {
    REGISTER_SUCCESS("Registration Success"),
    UPDATE_SUCCESS("successfully updated"),
    DELETE_SUCCESS("Successfully deleted one record")
    ;
    private String string;

    MessageTags(String string) {
        this.string = string;
    }

    @Override
    public String getString() {
        return string;
    }
}
