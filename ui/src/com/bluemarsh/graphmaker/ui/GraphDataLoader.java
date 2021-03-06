/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at http://www.netbeans.org/cddl.html
 * or http://www.netbeans.org/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.netbeans.org/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * The Original Software is GraphMaker. The Initial Developer of the Original
 * Software is Nathan L. Fiedler. Portions created by Nathan L. Fiedler
 * are Copyright (C) 2006-2008. All Rights Reserved.
 *
 * Contributor(s): Nathan L. Fiedler.
 *
 * $Id$
 */

package com.bluemarsh.graphmaker.ui;

import java.io.IOException;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.UniFileLoader;
import org.openide.util.NbBundle;

/**
 * An extension-based file loader for GraphMaker data files.
 *
 * @author Nathan Fiedler
 */
public class GraphDataLoader extends UniFileLoader {
    /** silence compiler warnings */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of GraphDataLoader.
     */
    public GraphDataLoader() {
        super(GraphDataObject.class.getName());
    }

    @Override
    protected String actionsContext() {
	return "Loaders/text/x-graphmaker/Actions/";
    }

    @Override
    protected MultiDataObject createMultiObject(FileObject fobj) throws
            DataObjectExistsException, IOException {
        return new GraphDataObject(fobj, this);
    }

    @Override
    protected String defaultDisplayName() {
        return NbBundle.getMessage(GraphDataLoader.class,
                "LBL_GraphDataLoader_DisplayName");
    }

    @Override
    protected void initialize() {
        super.initialize();
        // MIME type is defined in mime-resolver.xml, listed in layer file.
        getExtensions().addMimeType("text/x-graphmaker+xml");
    }
}
