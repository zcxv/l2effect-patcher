/*
 * Copyright (c) 2014 acmi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package acmi.l2.clientmod.unreal.bytecode.token;

import acmi.l2.clientmod.unreal.bytecode.BytecodeInput;
import acmi.l2.clientmod.unreal.bytecode.BytecodeOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LabelTable extends Token {
    public static final int OPCODE = 0x0c;

    private final Label[] labels;

    public LabelTable(Label... labels) {
        this.labels = labels;
    }

    public static LabelTable readFrom(BytecodeInput input) throws IOException {
        List<Label> labels = new ArrayList<>();
        Label tmp;
        do {
            tmp = new Label(input);
            if (tmp.nameRef == input.getNoneInd())
                break;
            labels.add(tmp);
        } while (true);
        return new LabelTable(labels.toArray(new Label[labels.size()]));
    }

    @Override
    protected int getOpcode() {
        return OPCODE;
    }

    public Label[] getLabels() {
        return labels;
    }

    @Override
    public void writeTo(BytecodeOutput output) throws IOException {
        super.writeTo(output);
        if (labels != null)
            for (Label label : labels) {
                label.writeTo(output);
            }
        new Label(output.getNoneInd(), 0xffff).writeTo(output);
    }

    @Override
    public String toString() {
        return "LabelTable("
                + (labels == null || labels.length == 0 ? "" : ", " + Arrays.stream(labels).map(Objects::toString).collect(Collectors.joining(", ")))
                + ')';
    }

    public static class Label {
        private final int nameRef;
        private final int offset;

        public Label(int nameRef, int offset) {
            this.nameRef = nameRef;
            this.offset = offset;
        }

        public Label(BytecodeInput input) throws IOException {
            this.nameRef = input.readCompactInt();
            this.offset = input.readInt();
        }

        public int getNameRef() {
            return nameRef;
        }

        public int getOffset() {
            return offset;
        }

        public void writeTo(BytecodeOutput output) throws IOException {
            output.writeCompactInt(nameRef);
            output.writeInt(offset);
        }

        @Override
        public String toString() {
            return "Label("
                    + nameRef
                    + ", " + offset
                    + ')';
        }
    }
}
