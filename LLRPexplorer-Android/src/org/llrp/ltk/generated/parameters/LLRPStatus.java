/*
 *
 * This file was generated by LLRP Code Generator
 * see http://llrp-toolkit.cvs.sourceforge.net/llrp-toolkit/
 * for more information
 * Generated on: Sun Apr 08 14:14:12 EDT 2012;
 *
 */

/*
 * Copyright 2007 ETH Zurich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 */
package org.llrp.ltk.generated.parameters;

import maximsblog.blogspot.com.llrpexplorer.Logger;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;

import org.llrp.ltk.exceptions.InvalidLLRPMessageException;
import org.llrp.ltk.exceptions.MissingParameterException;
import org.llrp.ltk.generated.LLRPConstants;
import org.llrp.ltk.generated.enumerations.StatusCode;
import org.llrp.ltk.generated.parameters.FieldError;
import org.llrp.ltk.generated.parameters.ParameterError;
import org.llrp.ltk.types.LLRPBitList;
import org.llrp.ltk.types.LLRPMessage;
import org.llrp.ltk.types.SignedShort;
import org.llrp.ltk.types.TLVParameter;
import org.llrp.ltk.types.TVParameter;
import org.llrp.ltk.types.UTF8String_UTF_8;
import org.llrp.ltk.types.UnsignedShort;

import java.util.LinkedList;
import java.util.List;


/**
 * See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=95&view=fit">LLRP Specification Section 14.2.2</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=151&view=fit">LLRP Specification Section 16.2.8.1</a>}


 */

/**
 * See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=95&view=fit">LLRP Specification Section 14.2.2</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=151&view=fit">LLRP Specification Section 16.2.8.1</a>}

      .
 */
public class LLRPStatus extends TLVParameter {
    public static final SignedShort TYPENUM = new SignedShort(287);
    private static final Logger LOGGER = Logger.getLogger(LLRPStatus.class);
    protected StatusCode statusCode;
    protected UTF8String_UTF_8 errorDescription;
    protected FieldError fieldError;
    protected ParameterError parameterError;

    /**
     * empty constructor to create new parameter.
     */
    public LLRPStatus() {
    }

    /**
     * Constructor to create parameter from binary encoded parameter
     * calls decodeBinary to decode parameter.
     * @param list to be decoded
     */
    public LLRPStatus(LLRPBitList list) {
        decodeBinary(list);
    }

    /**
    * Constructor to create parameter from xml encoded parameter
    * calls decodeXML to decode parameter.
    * @param element to be decoded
    */
    public LLRPStatus(Element element) throws InvalidLLRPMessageException {
        decodeXML(element);
    }

    /**
    * {@inheritDoc}
    */
    public LLRPBitList encodeBinarySpecific() {
        LLRPBitList resultBits = new LLRPBitList();

        if (statusCode == null) {
            LOGGER.warn(" statusCode not set");
            throw new MissingParameterException(
                " statusCode not set  for Parameter of Type LLRPStatus");
        }

        resultBits.append(statusCode.encodeBinary());

        if (errorDescription == null) {
            LOGGER.warn(" errorDescription not set");
            throw new MissingParameterException(
                " errorDescription not set  for Parameter of Type LLRPStatus");
        }

        resultBits.append(errorDescription.encodeBinary());

        if (fieldError == null) {
            // optional parameter, may be null
            LOGGER.info(" fieldError not set");
        } else {
            resultBits.append(fieldError.encodeBinary());
        }

        if (parameterError == null) {
            // optional parameter, may be null
            LOGGER.info(" parameterError not set");
        } else {
            resultBits.append(parameterError.encodeBinary());
        }

        return resultBits;
    }

    /**
    * {@inheritDoc}
    */
    public Content encodeXML(String name, Namespace ns) {
        // element in namespace defined by parent element
        Element element = new Element(name, ns);
        // child element are always in default LLRP namespace
        ns = Namespace.getNamespace("llrp", LLRPConstants.LLRPNAMESPACE);

        if (statusCode == null) {
            LOGGER.warn(" statusCode not set");
            throw new MissingParameterException(" statusCode not set");
        } else {
            element.addContent(statusCode.encodeXML("StatusCode", ns));
        }

        if (errorDescription == null) {
            LOGGER.warn(" errorDescription not set");
            throw new MissingParameterException(" errorDescription not set");
        } else {
            element.addContent(errorDescription.encodeXML("ErrorDescription", ns));
        }

        //parameters
        if (fieldError == null) {
            LOGGER.info("fieldError not set");
        } else {
            element.addContent(fieldError.encodeXML(fieldError.getClass()
                                                              .getSimpleName(),
                    ns));
        }

        if (parameterError == null) {
            LOGGER.info("parameterError not set");
        } else {
            element.addContent(parameterError.encodeXML(
                    parameterError.getClass().getSimpleName(), ns));
        }

        return element;
    }

    /**
    * {@inheritDoc}
    */
    protected void decodeBinarySpecific(LLRPBitList binary) {
        int position = 0;
        int tempByteLength;
        int tempLength = 0;
        int count;
        SignedShort type;
        int fieldCount;
        Custom custom;
        statusCode = new StatusCode(binary.subList(position, StatusCode.length()));
        position += StatusCode.length();
        // array. first 16 bits indicate length of array
        fieldCount = new UnsignedShort(binary.subList(position,
                    UnsignedShort.length())).toShort();
        tempLength = (UTF8String_UTF_8.length() * fieldCount) +
            UnsignedShort.length();
        errorDescription = new UTF8String_UTF_8(binary.subList(position,
                    tempLength));
        position += tempLength;
        LOGGER.debug("decoding array of type: UTF8String_UTF_8 with " +
            tempLength + " length");

        //might need padding
        // must always be blocks of 8 bites, if it is a bitlist, this might not be automatically the case
        if ((tempLength % 8) > 0) {
            position += (8 - (tempLength % 8));
            LOGGER.info("padding needed for errorDescription ");
        }

        // look ahead to see type
        // may be optional or exactly once
        type = null;
        tempByteLength = 0;
        tempLength = 0;

        try {
            // if first bit is one it is a TV Parameter
            if (binary.get(position)) {
                // do not take the first bit as it is always 1
                type = new SignedShort(binary.subList(position + 1, 7));
            } else {
                type = new SignedShort(binary.subList(position +
                            RESERVEDLENGTH, TYPENUMBERLENGTH));
                tempByteLength = new UnsignedShort(binary.subList(position +
                            RESERVEDLENGTH + TYPENUMBERLENGTH,
                            UnsignedShort.length())).toShort();
                tempLength = 8 * tempByteLength;
            }
        } catch (IllegalArgumentException le) {
            // if an IllegalArgumentException is thrown, list was not long enough so the parameter is missing
            LOGGER.info(
                "LLRPStatus misses optional parameter of type FieldError");
        }

        if (binary.get(position)) {
            // length can statically be determined for TV Parameters
            tempLength = fieldError.length();
        }

        if ((type != null) && type.equals(FieldError.TYPENUM)) {
            fieldError = new FieldError(binary.subList(position, tempLength));
            position += tempLength;
            LOGGER.debug(
                " fieldError is instantiated with FieldError with length" +
                tempLength);
        } else {
            LOGGER.info(
                "LLRPStatus misses optional parameter of type FieldError");
        }

        // look ahead to see type
        // may be optional or exactly once
        type = null;
        tempByteLength = 0;
        tempLength = 0;

        try {
            // if first bit is one it is a TV Parameter
            if (binary.get(position)) {
                // do not take the first bit as it is always 1
                type = new SignedShort(binary.subList(position + 1, 7));
            } else {
                type = new SignedShort(binary.subList(position +
                            RESERVEDLENGTH, TYPENUMBERLENGTH));
                tempByteLength = new UnsignedShort(binary.subList(position +
                            RESERVEDLENGTH + TYPENUMBERLENGTH,
                            UnsignedShort.length())).toShort();
                tempLength = 8 * tempByteLength;
            }
        } catch (IllegalArgumentException le) {
            // if an IllegalArgumentException is thrown, list was not long enough so the parameter is missing
            LOGGER.info(
                "LLRPStatus misses optional parameter of type ParameterError");
        }

        if (binary.get(position)) {
            // length can statically be determined for TV Parameters
            tempLength = parameterError.length();
        }

        if ((type != null) && type.equals(ParameterError.TYPENUM)) {
            parameterError = new ParameterError(binary.subList(position,
                        tempLength));
            position += tempLength;
            LOGGER.debug(
                " parameterError is instantiated with ParameterError with length" +
                tempLength);
        } else {
            LOGGER.info(
                "LLRPStatus misses optional parameter of type ParameterError");
        }
    }

    /**
    * {@inheritDoc}
    */
    public void decodeXML(Element element) throws InvalidLLRPMessageException {
        List<Element> tempList = null;
        boolean atLeastOnce = false;
        Custom custom;

        Element temp = null;

        // child element are always in default LLRP namespace
        Namespace ns = Namespace.getNamespace(LLRPConstants.LLRPNAMESPACE);

        temp = element.getChild("StatusCode", ns);

        if (temp != null) {
            statusCode = new StatusCode(temp);
        }

        element.removeChild("StatusCode", ns);
        temp = element.getChild("ErrorDescription", ns);

        if (temp != null) {
            errorDescription = new UTF8String_UTF_8(temp);
        }

        element.removeChild("ErrorDescription", ns);

        //parameter - not choices - no special actions needed
        temp = element.getChild("FieldError", ns);

        if (temp != null) {
            fieldError = new FieldError(temp);
            LOGGER.info("setting parameter fieldError for parameter LLRPStatus");
        }

        if (temp == null) {
            LOGGER.info(
                "LLRPStatus misses optional parameter of type fieldError");
        }

        element.removeChild("FieldError", ns);
        //parameter - not choices - no special actions needed
        temp = element.getChild("ParameterError", ns);

        if (temp != null) {
            parameterError = new ParameterError(temp);
            LOGGER.info(
                "setting parameter parameterError for parameter LLRPStatus");
        }

        if (temp == null) {
            LOGGER.info(
                "LLRPStatus misses optional parameter of type parameterError");
        }

        element.removeChild("ParameterError", ns);

        if (element.getChildren().size() > 0) {
            String message = "LLRPStatus has unknown element " +
                ((Element) element.getChildren().get(0)).getName();
            throw new InvalidLLRPMessageException(message);
        }
    }

    //setters
    /**
    * set statusCode of type StatusCode .
    * @param  statusCode to be set
    */
    public void setStatusCode(final StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    /**
    * set errorDescription of type UTF8String_UTF_8 .
    * @param  errorDescription to be set
    */
    public void setErrorDescription(final UTF8String_UTF_8 errorDescription) {
        this.errorDescription = errorDescription;
    }

    /**
    * set fieldError of type FieldError.
    * @param  fieldError to be set
    */
    public void setFieldError(final FieldError fieldError) {
        this.fieldError = fieldError;
    }

    /**
    * set parameterError of type ParameterError.
    * @param  parameterError to be set
    */
    public void setParameterError(final ParameterError parameterError) {
        this.parameterError = parameterError;
    }

    // end setter

    //getters
    /**
    * get statusCode of type StatusCode.
    * @return  StatusCode
    */
    public StatusCode getStatusCode() {
        return statusCode;
    }

    /**
    * get errorDescription of type  UTF8String_UTF_8.
    * @return  UTF8String_UTF_8
    */
    public UTF8String_UTF_8 getErrorDescription() {
        return errorDescription;
    }

    /**
    * get fieldError of type FieldError .
    * @return  FieldError
    */
    public FieldError getFieldError() {
        return fieldError;
    }

    /**
    * get parameterError of type ParameterError .
    * @return  ParameterError
    */
    public ParameterError getParameterError() {
        return parameterError;
    }

    // end getters

    //add methods

    // end add

    /**
    * For TLV Parameter length can not be determined at compile time. This method therefore always returns 0.
    * @return Integer always zero
    */
    public static Integer length() {
        return 0;
    }

    /**
    * {@inheritDoc}
    */
    public SignedShort getTypeNum() {
        return TYPENUM;
    }

    /**
    * {@inheritDoc}
    */
    public String getName() {
        return "LLRPStatus";
    }

    /**
    * return string representation. All field values but no parameters are included
    * @return String
    */
    public String toString() {
        String result = "LLRPStatus: ";
        result += ", statusCode: ";
        result += statusCode;
        result += ", errorDescription: ";
        result += errorDescription;
        result = result.replaceFirst(", ", "");

        return result;
    }
}
