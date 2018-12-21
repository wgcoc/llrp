/*
 *
 * This file was generated by LLRP Code Generator
 * see http://llrp-toolkit.cvs.sourceforge.net/llrp-toolkit/
 * for more information
 * Generated on: Sun Apr 08 14:14:11 EDT 2012;
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
import org.llrp.ltk.generated.interfaces.EPCParameter;
import org.llrp.ltk.types.Integer96_HEX;
import org.llrp.ltk.types.LLRPBitList;
import org.llrp.ltk.types.LLRPMessage;
import org.llrp.ltk.types.SignedShort;
import org.llrp.ltk.types.TLVParameter;
import org.llrp.ltk.types.TVParameter;
import org.llrp.ltk.types.UnsignedShort;

import java.util.LinkedList;
import java.util.List;


/**
 * This parameter carries 96-bit EPC identifier information.

See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=82&view=fit">LLRP Specification Section 13.2.3.2</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=144&view=fit">LLRP Specification Section 16.2.7.3.2</a>}


 */

/**
 * This parameter carries 96-bit EPC identifier information.

See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=82&view=fit">LLRP Specification Section 13.2.3.2</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=144&view=fit">LLRP Specification Section 16.2.7.3.2</a>}

      .
 */
public class EPC_96 extends TVParameter implements EPCParameter {
    public static final SignedShort TYPENUM = new SignedShort(13);
    private static final Logger LOGGER = Logger.getLogger(EPC_96.class);
    protected Integer96_HEX ePC;

    /**
     * empty constructor to create new parameter.
     */
    public EPC_96() {
    }

    /**
     * Constructor to create parameter from binary encoded parameter
     * calls decodeBinary to decode parameter.
     * @param list to be decoded
     */
    public EPC_96(LLRPBitList list) {
        decodeBinary(list);
    }

    /**
    * Constructor to create parameter from xml encoded parameter
    * calls decodeXML to decode parameter.
    * @param element to be decoded
    */
    public EPC_96(Element element) throws InvalidLLRPMessageException {
        decodeXML(element);
    }

    /**
    * {@inheritDoc}
    */
    public LLRPBitList encodeBinarySpecific() {
        LLRPBitList resultBits = new LLRPBitList();

        if (ePC == null) {
            LOGGER.warn(" ePC not set");
            throw new MissingParameterException(
                " ePC not set  for Parameter of Type EPC_96");
        }

        resultBits.append(ePC.encodeBinary());

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

        if (ePC == null) {
            LOGGER.warn(" ePC not set");
            throw new MissingParameterException(" ePC not set");
        } else {
            element.addContent(ePC.encodeXML("EPC", ns));
        }

        //parameters
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
        ePC = new Integer96_HEX(binary.subList(position, Integer96_HEX.length()));
        position += Integer96_HEX.length();
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

        temp = element.getChild("EPC", ns);

        if (temp != null) {
            ePC = new Integer96_HEX(temp);
        }

        element.removeChild("EPC", ns);

        if (element.getChildren().size() > 0) {
            String message = "EPC_96 has unknown element " +
                ((Element) element.getChildren().get(0)).getName();
            throw new InvalidLLRPMessageException(message);
        }
    }

    //setters
    /**
    * set ePC of type Integer96_HEX .
    * @param  ePC to be set
    */
    public void setEPC(final Integer96_HEX ePC) {
        this.ePC = ePC;
    }

    // end setter

    //getters
    /**
    * get ePC of type  Integer96_HEX.
    * @return  Integer96_HEX
    */
    public Integer96_HEX getEPC() {
        return ePC;
    }

    // end getters

    //add methods

    // end add

    /**
    * return length of parameter. For TV Parameter it is always length of its field plus 8 bits for type.
    * @return Integer giving length
    */
    public static Integer length() {
        int tempLength = PARAMETERTYPELENGTH;
        // the length of a TV parameter in bits is always the type 
        tempLength += Integer96_HEX.length();

        return tempLength;
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
        return "EPC_96";
    }

    /**
    * return string representation. All field values but no parameters are included
    * @return String
    */
    public String toString() {
        String result = "EPC_96: ";
        result += ", ePC: ";
        result += ePC;
        result = result.replaceFirst(", ", "");

        return result;
    }
}