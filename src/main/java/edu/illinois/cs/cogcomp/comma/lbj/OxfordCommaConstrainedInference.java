// Modifying this comment will cause the next execution of LBJava to overwrite this file.
// F1B88000000000000000D3C814A02C040140FB2D7CDDB8F10F89B8111228F28567B39C2A99189C84409CFD5D089B577751D55A7A15231DDBA75B2D8E435A645667B45585ADD9F8C45073A8F6D66CB1B9B8CFD464F7A902F160AFF5901F885185AAF801E286F27DDFC2CF68EEC9E138E945FE1264CAF10B8F7622A8000000

package edu.illinois.cs.cogcomp.comma.lbj;

import edu.illinois.cs.cogcomp.comma.datastructures.Comma;
import edu.illinois.cs.cogcomp.comma.datastructures.CommaProperties;
import edu.illinois.cs.cogcomp.comma.datastructures.Sentence;
import edu.illinois.cs.cogcomp.comma.readers.CommaParser;
import edu.illinois.cs.cogcomp.comma.readers.PrettyCorpusReader;
import edu.illinois.cs.cogcomp.core.datastructures.textannotation.*;
import edu.illinois.cs.cogcomp.infer.ilp.OJalgoHook;
import edu.illinois.cs.cogcomp.lbjava.classify.*;
import edu.illinois.cs.cogcomp.lbjava.infer.*;
import edu.illinois.cs.cogcomp.lbjava.io.IOUtilities;
import edu.illinois.cs.cogcomp.lbjava.learn.*;
import edu.illinois.cs.cogcomp.lbjava.parse.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class OxfordCommaConstrainedInference extends ILPInference
{
  public static Sentence findHead(Comma c)
  {
    return c.getSentence();
  }


  public OxfordCommaConstrainedInference() { }
  public OxfordCommaConstrainedInference(Sentence head)
  {
    super(head, new OJalgoHook());
    constraint = new OxfordCommaConstrainedInference$subjectto().makeConstraint(head);
  }

  public String getHeadType() { return "edu.illinois.cs.cogcomp.comma.datastructures.Sentence"; }
  public String[] getHeadFinderTypes()
  {
    return new String[]{ "edu.illinois.cs.cogcomp.comma.datastructures.Comma" };
  }

  public Normalizer getNormalizer(Learner c)
  {
    return new IdentityNormalizer();
  }
}

