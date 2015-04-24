<?xml version="1.0" encoding="utf-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
           targetNamespace="http://CV.org"
           xmlns:cv="http://CV.org">

    <xs:element name="cv" type="cv:cv_type"/>
    <xs:element name="gender" type="cv:gender_type"/>
    <xs:element name="name" type="cv:name_type"/>
    <xs:element name="first_name"/>
    <xs:element name="objective"/>
    <xs:element name="experience" type="cv:date_type"/>
    <xs:element name="school" type="cv:date_type"/>
    <xs:element name="skill"/>
    <xs:element name="language" type="cv:language2_type"/>
    <xs:element name="computer_sciences_skill" type="cv:computer_science_skill_type"/>

    <xs:complexType name="cv_type">
        <xs:sequence>
            <xs:element ref="cv:gender" minOccurs="1" maxOccurs="1"/>
            <xs:element ref="cv:name" minOccurs="1" maxOccurs="1"/>
            <xs:element ref="cv:first_name" minOccurs="1" maxOccurs="1"/>
            <xs:element ref="cv:objective" minOccurs="1" maxOccurs="1"/>
            <xs:element ref="cv:experience" minOccurs="1" maxOccurs="unbounded"/>
            <xs:element ref="cv:school" minOccurs="1" maxOccurs="unbounded"/>
            <xs:element ref="cv:skill" minOccurs="1" maxOccurs="1"/>
            <xs:element ref="cv:language" minOccurs="1" maxOccurs="unbounded"/>
            <xs:element ref="cv:computer_sciences_skill" minOccurs="1" maxOccurs="unbounded"/>
        </xs:sequence>
    </xs:complexType>

    <xs:complexType name="name_type">
        <xs:simpleContent>
            <xs:extension base="xs:string">
                <xs:attribute name="maidenName" type="xs:boolean" use="required"/>
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>

    <xs:simpleType name="level_type">
        <xs:restriction base="xs:integer">
            <xs:minInclusive value="0"/>
            <xs:maxInclusive value="20"/>
        </xs:restriction>
    </xs:simpleType>

    <xs:simpleType name="gender_type">
        <xs:restriction base="xs:string">
            <xs:enumeration value="M"/>
            <xs:enumeration value="Mme"/>
        </xs:restriction>
    </xs:simpleType>

    <xs:complexType name="date_type">
        <xs:simpleContent>
            <xs:extension base="xs:string">
                <xs:attribute name="begin" type="xs:date" use="required" />
                <xs:attribute name="end" type="xs:date" use="optional" />
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>

    <xs:complexType name="language_type">
        <xs:attribute name="name" type="xs:string" use="required"/>
        <xs:attribute name="level" type="cv:level_type" use="required"/>
    </xs:complexType>

    <xs:complexType name="language2_type">
        <xs:complexContent>
            <xs:extension base="cv:language_type">
                <xs:attribute name="description" type="xs:string" use="optional"/>
            </xs:extension>
        </xs:complexContent>
    </xs:complexType>

    <xs:complexType name="computer_science_skill_type">
        <xs:attribute name="name" type="xs:string" use="required"/>
        <xs:attribute name="level" type="cv:level_type" use="required"/>
    </xs:complexType>

</xs:schema>
