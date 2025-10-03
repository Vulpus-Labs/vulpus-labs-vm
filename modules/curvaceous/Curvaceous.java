package com.vulpuslabs.curvaceous;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.modules.curvaceous.*;
import com.vulpuslabs.vulpes.values.inputs.DisconnectableInput;
import com.vulpuslabs.vulpes.values.inputs.InputOrKnob;
import com.vulpuslabs.vulpes.values.ranges.Range;
import com.vulpuslabs.vulpes.values.events.*;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

//[/user-imports]


public class Curvaceous extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public Curvaceous( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Curvaceous", ModuleType.ModuleType_CVProcessors, 3.0 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "a405f996674f4472a43e60e9ab6ddec5" );
   }

void InitializeControls()
{

      textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "CURVACEOUS" );
      AddComponent( textLabel2 );
      textLabel2.SetWantsMouseNotifications( false );
      textLabel2.SetPosition( 0, 0 );
      textLabel2.SetSize( 216, 15 );
      textLabel2.SetEditable( false, false );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel2.SetBorderSize( 1 );
      textLabel2.SetMultiLineEdit( false );
      textLabel2.SetIsNumberEditor( false );
      textLabel2.SetNumberEditorRange( 0, 100 );
      textLabel2.SetNumberEditorInterval( 1 );
      textLabel2.SetNumberEditorUsesMouseWheel( false );
      textLabel2.SetHasCustomTextHoverColor( false );
      textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel2.SetFont( "Arial", 10, true, false );

      textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "VULPUS LABS" );
      AddComponent( textLabel3 );
      textLabel3.SetWantsMouseNotifications( false );
      textLabel3.SetPosition( 0, 345 );
      textLabel3.SetSize( 216, 15 );
      textLabel3.SetEditable( false, false );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel3.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel3.SetBorderSize( 1 );
      textLabel3.SetMultiLineEdit( false );
      textLabel3.SetIsNumberEditor( false );
      textLabel3.SetNumberEditorRange( 0, 100 );
      textLabel3.SetNumberEditorInterval( 1 );
      textLabel3.SetNumberEditorUsesMouseWheel( false );
      textLabel3.SetHasCustomTextHoverColor( false );
      textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetFont( "Arial", 10, true, false );

      xStartCv2 = new VoltageAudioJack( "xStartCv2", "X Start CV 2", this, JackType.JackType_AudioInput );
      AddComponent( xStartCv2 );
      xStartCv2.SetWantsMouseNotifications( false );
      xStartCv2.SetPosition( 69, 132 );
      xStartCv2.SetSize( 25, 25 );
      xStartCv2.SetSkin( "Mini Jack 25px" );

      xStartCv3 = new VoltageAudioJack( "xStartCv3", "X Start CV 3", this, JackType.JackType_AudioInput );
      AddComponent( xStartCv3 );
      xStartCv3.SetWantsMouseNotifications( false );
      xStartCv3.SetPosition( 69, 162 );
      xStartCv3.SetSize( 25, 25 );
      xStartCv3.SetSkin( "Mini Jack 25px" );

      xStartCv4 = new VoltageAudioJack( "xStartCv4", "X Start CV 4", this, JackType.JackType_AudioInput );
      AddComponent( xStartCv4 );
      xStartCv4.SetWantsMouseNotifications( false );
      xStartCv4.SetPosition( 69, 192 );
      xStartCv4.SetSize( 25, 25 );
      xStartCv4.SetSkin( "Mini Jack 25px" );

      xStartCv5 = new VoltageAudioJack( "xStartCv5", "X Start CV 5", this, JackType.JackType_AudioInput );
      AddComponent( xStartCv5 );
      xStartCv5.SetWantsMouseNotifications( false );
      xStartCv5.SetPosition( 69, 222 );
      xStartCv5.SetSize( 25, 25 );
      xStartCv5.SetSkin( "Mini Jack 25px" );

      xStartCv6 = new VoltageAudioJack( "xStartCv6", "X Start CV 6", this, JackType.JackType_AudioInput );
      AddComponent( xStartCv6 );
      xStartCv6.SetWantsMouseNotifications( false );
      xStartCv6.SetPosition( 69, 252 );
      xStartCv6.SetSize( 25, 25 );
      xStartCv6.SetSkin( "Mini Jack 25px" );

      xStartCv7 = new VoltageAudioJack( "xStartCv7", "X Start CV 7", this, JackType.JackType_AudioInput );
      AddComponent( xStartCv7 );
      xStartCv7.SetWantsMouseNotifications( false );
      xStartCv7.SetPosition( 69, 282 );
      xStartCv7.SetSize( 25, 25 );
      xStartCv7.SetSkin( "Mini Jack 25px" );

      xStartKnob3 = new VoltageKnob( "xStartKnob3", "X Start 3", this, -5, 5, 0 );
      AddComponent( xStartKnob3 );
      xStartKnob3.SetWantsMouseNotifications( false );
      xStartKnob3.SetPosition( 95, 163 );
      xStartKnob3.SetSize( 27, 27 );
      xStartKnob3.SetSkin( "Plastic Yellow" );
      xStartKnob3.SetRange( -5, 5, 0, false, 0 );
      xStartKnob3.SetKnobParams( 215, 145 );
      xStartKnob3.SetUnits( "v" );
      xStartKnob3.DisplayValueInPercent( false );
      xStartKnob3.SetKnobAdjustsRing( true );

      xStartKnob5 = new VoltageKnob( "xStartKnob5", "X Start 5", this, -5, 5, 0 );
      AddComponent( xStartKnob5 );
      xStartKnob5.SetWantsMouseNotifications( false );
      xStartKnob5.SetPosition( 95, 223 );
      xStartKnob5.SetSize( 27, 27 );
      xStartKnob5.SetSkin( "Plastic Yellow" );
      xStartKnob5.SetRange( -5, 5, 0, false, 0 );
      xStartKnob5.SetKnobParams( 215, 145 );
      xStartKnob5.SetUnits( "v" );
      xStartKnob5.DisplayValueInPercent( false );
      xStartKnob5.SetKnobAdjustsRing( true );

      xStartKnob2 = new VoltageKnob( "xStartKnob2", "X Start 2", this, -5, 5, 0 );
      AddComponent( xStartKnob2 );
      xStartKnob2.SetWantsMouseNotifications( false );
      xStartKnob2.SetPosition( 95, 133 );
      xStartKnob2.SetSize( 27, 27 );
      xStartKnob2.SetSkin( "Plastic Yellow" );
      xStartKnob2.SetRange( -5, 5, 0, false, 0 );
      xStartKnob2.SetKnobParams( 215, 145 );
      xStartKnob2.SetUnits( "v" );
      xStartKnob2.DisplayValueInPercent( false );
      xStartKnob2.SetKnobAdjustsRing( true );

      xStartKnob6 = new VoltageKnob( "xStartKnob6", "X Start 6", this, -5, 5, 0 );
      AddComponent( xStartKnob6 );
      xStartKnob6.SetWantsMouseNotifications( false );
      xStartKnob6.SetPosition( 95, 253 );
      xStartKnob6.SetSize( 27, 27 );
      xStartKnob6.SetSkin( "Plastic Yellow" );
      xStartKnob6.SetRange( -5, 5, 0, false, 0 );
      xStartKnob6.SetKnobParams( 215, 145 );
      xStartKnob6.SetUnits( "v" );
      xStartKnob6.DisplayValueInPercent( false );
      xStartKnob6.SetKnobAdjustsRing( true );

      xStartKnob4 = new VoltageKnob( "xStartKnob4", "X Start 4", this, -5, 5, 0 );
      AddComponent( xStartKnob4 );
      xStartKnob4.SetWantsMouseNotifications( false );
      xStartKnob4.SetPosition( 95, 193 );
      xStartKnob4.SetSize( 27, 27 );
      xStartKnob4.SetSkin( "Plastic Yellow" );
      xStartKnob4.SetRange( -5, 5, 0, false, 0 );
      xStartKnob4.SetKnobParams( 215, 145 );
      xStartKnob4.SetUnits( "v" );
      xStartKnob4.DisplayValueInPercent( false );
      xStartKnob4.SetKnobAdjustsRing( true );

      xStartKnob7 = new VoltageKnob( "xStartKnob7", "X Start 7", this, -5, 5, 0 );
      AddComponent( xStartKnob7 );
      xStartKnob7.SetWantsMouseNotifications( false );
      xStartKnob7.SetPosition( 95, 283 );
      xStartKnob7.SetSize( 27, 27 );
      xStartKnob7.SetSkin( "Plastic Yellow" );
      xStartKnob7.SetRange( -5, 5, 0, false, 0 );
      xStartKnob7.SetKnobParams( 215, 145 );
      xStartKnob7.SetUnits( "v" );
      xStartKnob7.DisplayValueInPercent( false );
      xStartKnob7.SetKnobAdjustsRing( true );

      yStartCv5 = new VoltageAudioJack( "yStartCv5", "Y Start CV 5", this, JackType.JackType_AudioInput );
      AddComponent( yStartCv5 );
      yStartCv5.SetWantsMouseNotifications( false );
      yStartCv5.SetPosition( 126, 222 );
      yStartCv5.SetSize( 25, 25 );
      yStartCv5.SetSkin( "Mini Jack 25px" );

      yStartCv2 = new VoltageAudioJack( "yStartCv2", "Y Start CV 2", this, JackType.JackType_AudioInput );
      AddComponent( yStartCv2 );
      yStartCv2.SetWantsMouseNotifications( false );
      yStartCv2.SetPosition( 126, 132 );
      yStartCv2.SetSize( 25, 25 );
      yStartCv2.SetSkin( "Mini Jack 25px" );

      yStartCv4 = new VoltageAudioJack( "yStartCv4", "Y Start CV 4", this, JackType.JackType_AudioInput );
      AddComponent( yStartCv4 );
      yStartCv4.SetWantsMouseNotifications( false );
      yStartCv4.SetPosition( 126, 192 );
      yStartCv4.SetSize( 25, 25 );
      yStartCv4.SetSkin( "Mini Jack 25px" );

      yStartCv6 = new VoltageAudioJack( "yStartCv6", "Y Start CV 6", this, JackType.JackType_AudioInput );
      AddComponent( yStartCv6 );
      yStartCv6.SetWantsMouseNotifications( false );
      yStartCv6.SetPosition( 126, 252 );
      yStartCv6.SetSize( 25, 25 );
      yStartCv6.SetSkin( "Mini Jack 25px" );

      yStartCv3 = new VoltageAudioJack( "yStartCv3", "Y Start CV 3", this, JackType.JackType_AudioInput );
      AddComponent( yStartCv3 );
      yStartCv3.SetWantsMouseNotifications( false );
      yStartCv3.SetPosition( 126, 162 );
      yStartCv3.SetSize( 25, 25 );
      yStartCv3.SetSkin( "Mini Jack 25px" );

      yStartCv1 = new VoltageAudioJack( "yStartCv1", "Y Start CV 1", this, JackType.JackType_AudioInput );
      AddComponent( yStartCv1 );
      yStartCv1.SetWantsMouseNotifications( false );
      yStartCv1.SetPosition( 126, 102 );
      yStartCv1.SetSize( 25, 25 );
      yStartCv1.SetSkin( "Mini Jack 25px" );

      yStartCv7 = new VoltageAudioJack( "yStartCv7", "Y Start CV 7", this, JackType.JackType_AudioInput );
      AddComponent( yStartCv7 );
      yStartCv7.SetWantsMouseNotifications( false );
      yStartCv7.SetPosition( 126, 282 );
      yStartCv7.SetSize( 25, 25 );
      yStartCv7.SetSkin( "Mini Jack 25px" );

      yStartCv8 = new VoltageAudioJack( "yStartCv8", "Y Start CV 8", this, JackType.JackType_AudioInput );
      AddComponent( yStartCv8 );
      yStartCv8.SetWantsMouseNotifications( false );
      yStartCv8.SetPosition( 126, 312 );
      yStartCv8.SetSize( 25, 25 );
      yStartCv8.SetSkin( "Mini Jack 25px" );

      yStartKnob1 = new VoltageKnob( "yStartKnob1", "Y Start 1", this, -5, 5, 0 );
      AddComponent( yStartKnob1 );
      yStartKnob1.SetWantsMouseNotifications( false );
      yStartKnob1.SetPosition( 152, 103 );
      yStartKnob1.SetSize( 27, 27 );
      yStartKnob1.SetSkin( "Plastic Yellow" );
      yStartKnob1.SetRange( -5, 5, 0, false, 0 );
      yStartKnob1.SetKnobParams( 215, 145 );
      yStartKnob1.SetUnits( "v" );
      yStartKnob1.DisplayValueInPercent( false );
      yStartKnob1.SetKnobAdjustsRing( true );

      yStartKnob6 = new VoltageKnob( "yStartKnob6", "Y Start 6", this, -5, 5, 0 );
      AddComponent( yStartKnob6 );
      yStartKnob6.SetWantsMouseNotifications( false );
      yStartKnob6.SetPosition( 152, 253 );
      yStartKnob6.SetSize( 27, 27 );
      yStartKnob6.SetSkin( "Plastic Yellow" );
      yStartKnob6.SetRange( -5, 5, 0, false, 0 );
      yStartKnob6.SetKnobParams( 215, 145 );
      yStartKnob6.SetUnits( "v" );
      yStartKnob6.DisplayValueInPercent( false );
      yStartKnob6.SetKnobAdjustsRing( true );

      yStartKnob3 = new VoltageKnob( "yStartKnob3", "Y Start 3", this, -5, 5, 0 );
      AddComponent( yStartKnob3 );
      yStartKnob3.SetWantsMouseNotifications( false );
      yStartKnob3.SetPosition( 152, 163 );
      yStartKnob3.SetSize( 27, 27 );
      yStartKnob3.SetSkin( "Plastic Yellow" );
      yStartKnob3.SetRange( -5, 5, 0, false, 0 );
      yStartKnob3.SetKnobParams( 215, 145 );
      yStartKnob3.SetUnits( "v" );
      yStartKnob3.DisplayValueInPercent( false );
      yStartKnob3.SetKnobAdjustsRing( true );

      yStartKnob5 = new VoltageKnob( "yStartKnob5", "Y Start 5", this, -5, 5, 0 );
      AddComponent( yStartKnob5 );
      yStartKnob5.SetWantsMouseNotifications( false );
      yStartKnob5.SetPosition( 152, 223 );
      yStartKnob5.SetSize( 27, 27 );
      yStartKnob5.SetSkin( "Plastic Yellow" );
      yStartKnob5.SetRange( -5, 5, 0, false, 0 );
      yStartKnob5.SetKnobParams( 215, 145 );
      yStartKnob5.SetUnits( "v" );
      yStartKnob5.DisplayValueInPercent( false );
      yStartKnob5.SetKnobAdjustsRing( true );

      yStartKnob4 = new VoltageKnob( "yStartKnob4", "Y Start 4", this, -5, 5, 0 );
      AddComponent( yStartKnob4 );
      yStartKnob4.SetWantsMouseNotifications( false );
      yStartKnob4.SetPosition( 152, 193 );
      yStartKnob4.SetSize( 27, 27 );
      yStartKnob4.SetSkin( "Plastic Yellow" );
      yStartKnob4.SetRange( -5, 5, 0, false, 0 );
      yStartKnob4.SetKnobParams( 215, 145 );
      yStartKnob4.SetUnits( "v" );
      yStartKnob4.DisplayValueInPercent( false );
      yStartKnob4.SetKnobAdjustsRing( true );

      yStartKnob7 = new VoltageKnob( "yStartKnob7", "Y Start 7", this, -5, 5, 0 );
      AddComponent( yStartKnob7 );
      yStartKnob7.SetWantsMouseNotifications( false );
      yStartKnob7.SetPosition( 152, 283 );
      yStartKnob7.SetSize( 27, 27 );
      yStartKnob7.SetSkin( "Plastic Yellow" );
      yStartKnob7.SetRange( -5, 5, 0, false, 0 );
      yStartKnob7.SetKnobParams( 215, 145 );
      yStartKnob7.SetUnits( "v" );
      yStartKnob7.DisplayValueInPercent( false );
      yStartKnob7.SetKnobAdjustsRing( true );

      yStartKnob2 = new VoltageKnob( "yStartKnob2", "Y Start 2", this, -5, 5, 0 );
      AddComponent( yStartKnob2 );
      yStartKnob2.SetWantsMouseNotifications( false );
      yStartKnob2.SetPosition( 152, 133 );
      yStartKnob2.SetSize( 27, 27 );
      yStartKnob2.SetSkin( "Plastic Yellow" );
      yStartKnob2.SetRange( -5, 5, 0, false, 0 );
      yStartKnob2.SetKnobParams( 215, 145 );
      yStartKnob2.SetUnits( "v" );
      yStartKnob2.DisplayValueInPercent( false );
      yStartKnob2.SetKnobAdjustsRing( true );

      yStartKnob8 = new VoltageKnob( "yStartKnob8", "Y Start 8", this, -5, 5, 0 );
      AddComponent( yStartKnob8 );
      yStartKnob8.SetWantsMouseNotifications( false );
      yStartKnob8.SetPosition( 153, 313 );
      yStartKnob8.SetSize( 27, 27 );
      yStartKnob8.SetSkin( "Plastic Yellow" );
      yStartKnob8.SetRange( -5, 5, 0, false, 0 );
      yStartKnob8.SetKnobParams( 215, 145 );
      yStartKnob8.SetUnits( "v" );
      yStartKnob8.DisplayValueInPercent( false );
      yStartKnob8.SetKnobAdjustsRing( true );

      curve5 = new VoltageKnob( "curve5", "Curve 5", this, 0.0, 5, 0 );
      AddComponent( curve5 );
      curve5.SetWantsMouseNotifications( false );
      curve5.SetPosition( 185, 222 );
      curve5.SetSize( 25, 25 );
      curve5.SetSkin( "Dial Cherry" );
      curve5.SetRange( 0.0, 5, 0, false, 6 );
      curve5.SetKnobParams( 215, 145 );
      curve5.DisplayValueInPercent( false );
      curve5.SetKnobAdjustsRing( true );

      curve2 = new VoltageKnob( "curve2", "Curve 2", this, 0.0, 5, 0 );
      AddComponent( curve2 );
      curve2.SetWantsMouseNotifications( false );
      curve2.SetPosition( 185, 132 );
      curve2.SetSize( 25, 25 );
      curve2.SetSkin( "Dial Cherry" );
      curve2.SetRange( 0.0, 5, 0, false, 6 );
      curve2.SetKnobParams( 215, 145 );
      curve2.DisplayValueInPercent( false );
      curve2.SetKnobAdjustsRing( true );

      curve3 = new VoltageKnob( "curve3", "Curve 3", this, 0.0, 5, 0 );
      AddComponent( curve3 );
      curve3.SetWantsMouseNotifications( false );
      curve3.SetPosition( 185, 162 );
      curve3.SetSize( 25, 25 );
      curve3.SetSkin( "Dial Cherry" );
      curve3.SetRange( 0.0, 5, 0, false, 6 );
      curve3.SetKnobParams( 215, 145 );
      curve3.DisplayValueInPercent( false );
      curve3.SetKnobAdjustsRing( true );

      curve1 = new VoltageKnob( "curve1", "Curve 1", this, 1, 5, 2 );
      AddComponent( curve1 );
      curve1.SetWantsMouseNotifications( false );
      curve1.SetPosition( 185, 102 );
      curve1.SetSize( 25, 25 );
      curve1.SetSkin( "Dial Cherry" );
      curve1.SetRange( 1, 5, 2, false, 5 );
      curve1.SetKnobParams( 273, 145 );
      curve1.DisplayValueInPercent( false );
      curve1.SetKnobAdjustsRing( true );

      curve7 = new VoltageKnob( "curve7", "Curve 7", this, 0.0, 5, 0 );
      AddComponent( curve7 );
      curve7.SetWantsMouseNotifications( false );
      curve7.SetPosition( 185, 282 );
      curve7.SetSize( 25, 25 );
      curve7.SetSkin( "Dial Cherry" );
      curve7.SetRange( 0.0, 5, 0, false, 6 );
      curve7.SetKnobParams( 215, 145 );
      curve7.DisplayValueInPercent( false );
      curve7.SetKnobAdjustsRing( true );

      curve4 = new VoltageKnob( "curve4", "Curve 4", this, 0.0, 5, 0 );
      AddComponent( curve4 );
      curve4.SetWantsMouseNotifications( false );
      curve4.SetPosition( 185, 192 );
      curve4.SetSize( 25, 25 );
      curve4.SetSkin( "Dial Cherry" );
      curve4.SetRange( 0.0, 5, 0, false, 6 );
      curve4.SetKnobParams( 215, 145 );
      curve4.DisplayValueInPercent( false );
      curve4.SetKnobAdjustsRing( true );

      curve6 = new VoltageKnob( "curve6", "Curve 6", this, 0.0, 5, 0 );
      AddComponent( curve6 );
      curve6.SetWantsMouseNotifications( false );
      curve6.SetPosition( 185, 252 );
      curve6.SetSize( 25, 25 );
      curve6.SetSkin( "Dial Cherry" );
      curve6.SetRange( 0.0, 5, 0, false, 6 );
      curve6.SetKnobParams( 215, 145 );
      curve6.DisplayValueInPercent( false );
      curve6.SetKnobAdjustsRing( true );

      curveDisplay = new VoltageCanvas( "curveDisplay", "Curve Display", this, 136, 54 );
      AddComponent( curveDisplay );
      curveDisplay.SetWantsMouseNotifications( false );
      curveDisplay.SetPosition( 72, 20 );
      curveDisplay.SetSize( 136, 54 );

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "X START" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 68, 80 );
      textLabel4.SetSize( 56, 15 );
      textLabel4.SetEditable( false, false );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel4.SetBkColor( new Color( 192, 32, 32, 255 ) );
      textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel4.SetBorderSize( 1 );
      textLabel4.SetMultiLineEdit( false );
      textLabel4.SetIsNumberEditor( false );
      textLabel4.SetNumberEditorRange( 0, 100 );
      textLabel4.SetNumberEditorInterval( 1 );
      textLabel4.SetNumberEditorUsesMouseWheel( false );
      textLabel4.SetHasCustomTextHoverColor( false );
      textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetFont( "Arial", 10, true, false );

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "START >>>" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 68, 107 );
      textLabel9.SetSize( 56, 15 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.Right );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel9.SetBkColor( new Color( 128, 0, 0, 0 ) );
      textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel9.SetBorderSize( 1 );
      textLabel9.SetMultiLineEdit( false );
      textLabel9.SetIsNumberEditor( false );
      textLabel9.SetNumberEditorRange( 0, 100 );
      textLabel9.SetNumberEditorInterval( 1 );
      textLabel9.SetNumberEditorUsesMouseWheel( false );
      textLabel9.SetHasCustomTextHoverColor( false );
      textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetFont( "Arial", 10, true, false );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "END >>>" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 68, 317 );
      textLabel10.SetSize( 56, 15 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.Right );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 128, 0, 0, 0 ) );
      textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel10.SetBorderSize( 1 );
      textLabel10.SetMultiLineEdit( false );
      textLabel10.SetIsNumberEditor( false );
      textLabel10.SetNumberEditorRange( 0, 100 );
      textLabel10.SetNumberEditorInterval( 1 );
      textLabel10.SetNumberEditorUsesMouseWheel( false );
      textLabel10.SetHasCustomTextHoverColor( false );
      textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel10.SetFont( "Arial", 10, true, false );

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "Y START" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 125, 80 );
      textLabel5.SetSize( 56, 15 );
      textLabel5.SetEditable( false, false );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel5.SetBkColor( new Color( 192, 32, 32, 255 ) );
      textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel5.SetBorderSize( 1 );
      textLabel5.SetMultiLineEdit( false );
      textLabel5.SetIsNumberEditor( false );
      textLabel5.SetNumberEditorRange( 0, 100 );
      textLabel5.SetNumberEditorInterval( 1 );
      textLabel5.SetNumberEditorUsesMouseWheel( false );
      textLabel5.SetHasCustomTextHoverColor( false );
      textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel5.SetFont( "Arial", 10, true, false );

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "CURVE" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 183, 80 );
      textLabel6.SetSize( 29, 15 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel6.SetBkColor( new Color( 192, 32, 32, 255 ) );
      textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel6.SetBorderSize( 1 );
      textLabel6.SetMultiLineEdit( false );
      textLabel6.SetIsNumberEditor( false );
      textLabel6.SetNumberEditorRange( 0, 100 );
      textLabel6.SetNumberEditorInterval( 1 );
      textLabel6.SetNumberEditorUsesMouseWheel( false );
      textLabel6.SetHasCustomTextHoverColor( false );
      textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel6.SetFont( "Arial", 10, true, false );

      polyFrequencyIn = new VoltagePolyJack( "polyFrequencyIn", "Poly Frequency In", this, JackType.JackType_PolyInput );
      AddComponent( polyFrequencyIn );
      polyFrequencyIn.SetWantsMouseNotifications( false );
      polyFrequencyIn.SetPosition( 6, 40 );
      polyFrequencyIn.SetSize( 25, 25 );
      polyFrequencyIn.SetSkin( "Poly Jack Straight" );

      polyHardSyncIn = new VoltagePolyJack( "polyHardSyncIn", "Poly Hard Sync Input", this, JackType.JackType_PolyInput );
      AddComponent( polyHardSyncIn );
      polyHardSyncIn.SetWantsMouseNotifications( false );
      polyHardSyncIn.SetPosition( 36, 40 );
      polyHardSyncIn.SetSize( 25, 25 );
      polyHardSyncIn.SetSkin( "Poly Jack Straight" );

      polyFreqMod = new VoltagePolyJack( "polyFreqMod", "Poly Frequency Modulation In", this, JackType.JackType_PolyInput );
      AddComponent( polyFreqMod );
      polyFreqMod.SetWantsMouseNotifications( false );
      polyFreqMod.SetPosition( 6, 90 );
      polyFreqMod.SetSize( 25, 25 );
      polyFreqMod.SetSkin( "Poly Jack Straight" );

      monoFreqMod = new VoltageAudioJack( "monoFreqMod", "Mono Frequency Modulation In", this, JackType.JackType_AudioInput );
      AddComponent( monoFreqMod );
      monoFreqMod.SetWantsMouseNotifications( false );
      monoFreqMod.SetPosition( 6, 135 );
      monoFreqMod.SetSize( 25, 25 );
      monoFreqMod.SetSkin( "Jack Round Pink Ring" );

      pitchKnob = new VoltageKnob( "pitchKnob", "Pitch Control", this, -7, 7, 0 );
      AddComponent( pitchKnob );
      pitchKnob.SetWantsMouseNotifications( false );
      pitchKnob.SetPosition( 9, 201 );
      pitchKnob.SetSize( 50, 50 );
      pitchKnob.SetSkin( "Dial Lemon" );
      pitchKnob.SetRingSkin( "Crescent Lemon/Lime" );
      pitchKnob.SetRange( -7, 7, 0, true, 0 );
      pitchKnob.SetKnobParams( 215, 145 );
      pitchKnob.DisplayValueInPercent( false );
      pitchKnob.SetKnobAdjustsRing( true );

      monoFreqModAmount = new VoltageKnob( "monoFreqModAmount", "Mono Frequency Modulation Amount", this, -1, 1, 0 );
      AddComponent( monoFreqModAmount );
      monoFreqModAmount.SetWantsMouseNotifications( false );
      monoFreqModAmount.SetPosition( 36, 135 );
      monoFreqModAmount.SetSize( 27, 27 );
      monoFreqModAmount.SetSkin( "Plastic Red" );
      monoFreqModAmount.SetRange( -1, 1, 0, false, 0 );
      monoFreqModAmount.SetKnobParams( 215, 145 );
      monoFreqModAmount.SetUnits( "v" );
      monoFreqModAmount.DisplayValueInPercent( false );
      monoFreqModAmount.SetKnobAdjustsRing( true );

      polyFreqModAmount = new VoltageKnob( "polyFreqModAmount", "Poly Frequency Modulation Amount", this, -1, 1, 0 );
      AddComponent( polyFreqModAmount );
      polyFreqModAmount.SetWantsMouseNotifications( false );
      polyFreqModAmount.SetPosition( 36, 90 );
      polyFreqModAmount.SetSize( 27, 27 );
      polyFreqModAmount.SetSkin( "Plastic Red" );
      polyFreqModAmount.SetRange( -1, 1, 0, false, 0 );
      polyFreqModAmount.SetKnobParams( 215, 145 );
      polyFreqModAmount.SetUnits( "v" );
      polyFreqModAmount.DisplayValueInPercent( false );
      polyFreqModAmount.SetKnobAdjustsRing( true );

      freqRangeLo = new VoltageToggle( "freqRangeLo", "Frequency Range Low", this, false, 1 );
      AddComponent( freqRangeLo );
      freqRangeLo.SetWantsMouseNotifications( false );
      freqRangeLo.SetPosition( 4, 250 );
      freqRangeLo.SetSize( 19, 19 );
      freqRangeLo.SetSkin( "Square Concave Red" );
      freqRangeLo.ShowOverlay( true );
      freqRangeLo.SetOverlayText( "LO" );
      freqRangeLo.SetOverlayTextFont( "Arial", 10, true, false );
      freqRangeLo.SetOverlayTextColor( new Color( 0, 0, 0 ) );
      freqRangeLo.SetOverlayArea( 0, 0, 0, 0 );
      freqRangeLo.SetOverlayTextJustification( VoltageButton.Justification.Centered );

      freqRange32 = new VoltageToggle( "freqRange32", "Frequency Range 32'", this, false, 1 );
      AddComponent( freqRange32 );
      freqRange32.SetWantsMouseNotifications( false );
      freqRange32.SetPosition( 24, 250 );
      freqRange32.SetSize( 19, 19 );
      freqRange32.SetSkin( "Square Concave Red" );
      freqRange32.ShowOverlay( true );
      freqRange32.SetOverlayText( "32'" );
      freqRange32.SetOverlayTextFont( "Arial", 10, true, false );
      freqRange32.SetOverlayTextColor( new Color( 0, 0, 0 ) );
      freqRange32.SetOverlayArea( 0, 0, 0, 0 );
      freqRange32.SetOverlayTextJustification( VoltageButton.Justification.Centered );

      freqRange16 = new VoltageToggle( "freqRange16", "Frequency Range 16'", this, false, 1 );
      AddComponent( freqRange16 );
      freqRange16.SetWantsMouseNotifications( false );
      freqRange16.SetPosition( 44, 250 );
      freqRange16.SetSize( 19, 19 );
      freqRange16.SetSkin( "Square Concave Red" );
      freqRange16.ShowOverlay( true );
      freqRange16.SetOverlayText( "16'" );
      freqRange16.SetOverlayTextFont( "Arial", 10, true, false );
      freqRange16.SetOverlayTextColor( new Color( 0, 0, 0 ) );
      freqRange16.SetOverlayArea( 0, 0, 0, 0 );
      freqRange16.SetOverlayTextJustification( VoltageButton.Justification.Centered );

      freqRange8 = new VoltageToggle( "freqRange8", "Frequency Range 8'", this, true, 1 );
      AddComponent( freqRange8 );
      freqRange8.SetWantsMouseNotifications( false );
      freqRange8.SetPosition( 4, 270 );
      freqRange8.SetSize( 19, 19 );
      freqRange8.SetSkin( "Square Concave Red" );
      freqRange8.ShowOverlay( true );
      freqRange8.SetOverlayText( "8'" );
      freqRange8.SetOverlayTextFont( "Arial", 10, true, false );
      freqRange8.SetOverlayTextColor( new Color( 0, 0, 0 ) );
      freqRange8.SetOverlayArea( 0, 0, 0, 0 );
      freqRange8.SetOverlayTextJustification( VoltageButton.Justification.Centered );

      freqRange4 = new VoltageToggle( "freqRange4", "Frequency Range 4'", this, false, 1 );
      AddComponent( freqRange4 );
      freqRange4.SetWantsMouseNotifications( false );
      freqRange4.SetPosition( 24, 270 );
      freqRange4.SetSize( 19, 19 );
      freqRange4.SetSkin( "Square Concave Red" );
      freqRange4.ShowOverlay( true );
      freqRange4.SetOverlayText( "4'" );
      freqRange4.SetOverlayTextFont( "Arial", 10, true, false );
      freqRange4.SetOverlayTextColor( new Color( 0, 0, 0 ) );
      freqRange4.SetOverlayArea( 0, 0, 0, 0 );
      freqRange4.SetOverlayTextJustification( VoltageButton.Justification.Centered );

      freqRange2 = new VoltageToggle( "freqRange2", "Frequency Range 2'", this, false, 1 );
      AddComponent( freqRange2 );
      freqRange2.SetWantsMouseNotifications( false );
      freqRange2.SetPosition( 44, 270 );
      freqRange2.SetSize( 19, 19 );
      freqRange2.SetSkin( "Square Concave Red" );
      freqRange2.ShowOverlay( true );
      freqRange2.SetOverlayText( "2'" );
      freqRange2.SetOverlayTextFont( "Arial", 10, true, false );
      freqRange2.SetOverlayTextColor( new Color( 0, 0, 0 ) );
      freqRange2.SetOverlayArea( 0, 0, 0, 0 );
      freqRange2.SetOverlayTextJustification( VoltageButton.Justification.Centered );

      polyOutput = new VoltagePolyJack( "polyOutput", "Poly Output", this, JackType.JackType_PolyOutput );
      AddComponent( polyOutput );
      polyOutput.SetWantsMouseNotifications( false );
      polyOutput.SetPosition( 21, 316 );
      polyOutput.SetSize( 25, 25 );
      polyOutput.SetSkin( "Poly Jack Straight" );

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "PITCH / SYNC" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 4, 20 );
      textLabel7.SetSize( 60, 15 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel7.SetBkColor( new Color( 192, 32, 32, 255 ) );
      textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel7.SetBorderSize( 1 );
      textLabel7.SetMultiLineEdit( false );
      textLabel7.SetIsNumberEditor( false );
      textLabel7.SetNumberEditorRange( 0, 100 );
      textLabel7.SetNumberEditorInterval( 1 );
      textLabel7.SetNumberEditorUsesMouseWheel( false );
      textLabel7.SetHasCustomTextHoverColor( false );
      textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel7.SetFont( "Arial", 10, true, false );

      textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "AUDIO OUT" );
      AddComponent( textLabel8 );
      textLabel8.SetWantsMouseNotifications( false );
      textLabel8.SetPosition( 4, 296 );
      textLabel8.SetSize( 60, 15 );
      textLabel8.SetEditable( false, false );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel8.SetBkColor( new Color( 192, 32, 32, 255 ) );
      textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel8.SetBorderSize( 1 );
      textLabel8.SetMultiLineEdit( false );
      textLabel8.SetIsNumberEditor( false );
      textLabel8.SetNumberEditorRange( 0, 100 );
      textLabel8.SetNumberEditorInterval( 1 );
      textLabel8.SetNumberEditorUsesMouseWheel( false );
      textLabel8.SetHasCustomTextHoverColor( false );
      textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel8.SetFont( "Arial", 10, true, false );

      textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "FREQ MOD" );
      AddComponent( textLabel11 );
      textLabel11.SetWantsMouseNotifications( false );
      textLabel11.SetPosition( 4, 70 );
      textLabel11.SetSize( 60, 15 );
      textLabel11.SetEditable( false, false );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel11.SetBkColor( new Color( 192, 32, 32, 255 ) );
      textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel11.SetBorderSize( 1 );
      textLabel11.SetMultiLineEdit( false );
      textLabel11.SetIsNumberEditor( false );
      textLabel11.SetNumberEditorRange( 0, 100 );
      textLabel11.SetNumberEditorInterval( 1 );
      textLabel11.SetNumberEditorUsesMouseWheel( false );
      textLabel11.SetHasCustomTextHoverColor( false );
      textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel11.SetFont( "Arial", 10, true, false );

      textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "PITCH" );
      AddComponent( textLabel13 );
      textLabel13.SetWantsMouseNotifications( false );
      textLabel13.SetPosition( 4, 180 );
      textLabel13.SetSize( 60, 15 );
      textLabel13.SetEditable( false, false );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel13.SetBkColor( new Color( 192, 32, 32, 255 ) );
      textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel13.SetBorderSize( 1 );
      textLabel13.SetMultiLineEdit( false );
      textLabel13.SetIsNumberEditor( false );
      textLabel13.SetNumberEditorRange( 0, 100 );
      textLabel13.SetNumberEditorInterval( 1 );
      textLabel13.SetNumberEditorUsesMouseWheel( false );
      textLabel13.SetHasCustomTextHoverColor( false );
      textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel13.SetFont( "Arial", 10, true, false );

      textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "-7" );
      AddComponent( textLabel14 );
      textLabel14.SetWantsMouseNotifications( false );
      textLabel14.SetPosition( 0, 233 );
      textLabel14.SetSize( 13, 15 );
      textLabel14.SetEditable( false, false );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.Right );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel14.SetBkColor( new Color( 128, 0, 0, 0 ) );
      textLabel14.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel14.SetBorderSize( 1 );
      textLabel14.SetMultiLineEdit( false );
      textLabel14.SetIsNumberEditor( false );
      textLabel14.SetNumberEditorRange( 0, 100 );
      textLabel14.SetNumberEditorInterval( 1 );
      textLabel14.SetNumberEditorUsesMouseWheel( false );
      textLabel14.SetHasCustomTextHoverColor( false );
      textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel14.SetFont( "Arial", 10, true, false );

      textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "+7" );
      AddComponent( textLabel15 );
      textLabel15.SetWantsMouseNotifications( false );
      textLabel15.SetPosition( 54, 234 );
      textLabel15.SetSize( 13, 15 );
      textLabel15.SetEditable( false, false );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.Left );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel15.SetBkColor( new Color( 128, 0, 0, 0 ) );
      textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel15.SetBorderSize( 1 );
      textLabel15.SetMultiLineEdit( false );
      textLabel15.SetIsNumberEditor( false );
      textLabel15.SetNumberEditorRange( 0, 100 );
      textLabel15.SetNumberEditorInterval( 1 );
      textLabel15.SetNumberEditorUsesMouseWheel( false );
      textLabel15.SetHasCustomTextHoverColor( false );
      textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel15.SetFont( "Arial", 10, true, false );

      polyFMModeSwitch = new VoltageSwitch( "polyFMModeSwitch", "Poly FM Mode Switch", this, 0 );
      AddComponent( polyFMModeSwitch );
      polyFMModeSwitch.SetWantsMouseNotifications( false );
      polyFMModeSwitch.SetPosition( 17, 119 );
      polyFMModeSwitch.SetSize( 30, 12 );
      polyFMModeSwitch.SetSkin( "Rocker Switch Plastic Orange Hor" );

      textLabel16 = new VoltageLabel( "textLabel16", "textLabel16", this, "LIN" );
      AddComponent( textLabel16 );
      textLabel16.SetWantsMouseNotifications( false );
      textLabel16.SetPosition( 4, 118 );
      textLabel16.SetSize( 13, 15 );
      textLabel16.SetEditable( false, false );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.Right );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel16.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel16.SetBkColor( new Color( 128, 0, 0, 0 ) );
      textLabel16.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel16.SetBorderSize( 1 );
      textLabel16.SetMultiLineEdit( false );
      textLabel16.SetIsNumberEditor( false );
      textLabel16.SetNumberEditorRange( 0, 100 );
      textLabel16.SetNumberEditorInterval( 1 );
      textLabel16.SetNumberEditorUsesMouseWheel( false );
      textLabel16.SetHasCustomTextHoverColor( false );
      textLabel16.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel16.SetFont( "Arial", 10, true, false );

      textLabel17 = new VoltageLabel( "textLabel17", "textLabel17", this, "EXP" );
      AddComponent( textLabel17 );
      textLabel17.SetWantsMouseNotifications( false );
      textLabel17.SetPosition( 46, 118 );
      textLabel17.SetSize( 18, 15 );
      textLabel17.SetEditable( false, false );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.Left );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel17.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel17.SetBkColor( new Color( 128, 0, 0, 0 ) );
      textLabel17.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel17.SetBorderSize( 1 );
      textLabel17.SetMultiLineEdit( false );
      textLabel17.SetIsNumberEditor( false );
      textLabel17.SetNumberEditorRange( 0, 100 );
      textLabel17.SetNumberEditorInterval( 1 );
      textLabel17.SetNumberEditorUsesMouseWheel( false );
      textLabel17.SetHasCustomTextHoverColor( false );
      textLabel17.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel17.SetFont( "Arial", 10, true, false );

      textLabel18 = new VoltageLabel( "textLabel18", "textLabel18", this, "LIN" );
      AddComponent( textLabel18 );
      textLabel18.SetWantsMouseNotifications( false );
      textLabel18.SetPosition( 4, 162 );
      textLabel18.SetSize( 13, 15 );
      textLabel18.SetEditable( false, false );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.Right );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel18.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel18.SetBkColor( new Color( 128, 0, 0, 0 ) );
      textLabel18.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel18.SetBorderSize( 1 );
      textLabel18.SetMultiLineEdit( false );
      textLabel18.SetIsNumberEditor( false );
      textLabel18.SetNumberEditorRange( 0, 100 );
      textLabel18.SetNumberEditorInterval( 1 );
      textLabel18.SetNumberEditorUsesMouseWheel( false );
      textLabel18.SetHasCustomTextHoverColor( false );
      textLabel18.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel18.SetFont( "Arial", 10, true, false );

      textLabel19 = new VoltageLabel( "textLabel19", "textLabel19", this, "EXP" );
      AddComponent( textLabel19 );
      textLabel19.SetWantsMouseNotifications( false );
      textLabel19.SetPosition( 46, 162 );
      textLabel19.SetSize( 18, 15 );
      textLabel19.SetEditable( false, false );
      textLabel19.SetJustificationFlags( VoltageLabel.Justification.Left );
      textLabel19.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel19.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel19.SetBkColor( new Color( 128, 0, 0, 0 ) );
      textLabel19.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel19.SetBorderSize( 1 );
      textLabel19.SetMultiLineEdit( false );
      textLabel19.SetIsNumberEditor( false );
      textLabel19.SetNumberEditorRange( 0, 100 );
      textLabel19.SetNumberEditorInterval( 1 );
      textLabel19.SetNumberEditorUsesMouseWheel( false );
      textLabel19.SetHasCustomTextHoverColor( false );
      textLabel19.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel19.SetFont( "Arial", 10, true, false );

      monoFMModeSwitch = new VoltageSwitch( "monoFMModeSwitch", "Mono FM Mode Switch", this, 0 );
      AddComponent( monoFMModeSwitch );
      monoFMModeSwitch.SetWantsMouseNotifications( false );
      monoFMModeSwitch.SetPosition( 17, 163 );
      monoFMModeSwitch.SetSize( 30, 12 );
      monoFMModeSwitch.SetSkin( "Rocker Switch Plastic Orange Hor" );
}



   //-------------------------------------------------------------------------------
   //  public void Initialize()

      //  Initialize will get called shortly after your module's constructor runs. You can use it to
      //  do any initialization that the auto-generated code doesn't handle.
   //-------------------------------------------------------------------------------
   @Override
   public void Initialize()
   {
      //[user-Initialize]   Add your own initialization code here
      curveControl = new CurveControl(
         connector.startSegment(yStartCv1, yStartKnob1, curve1),
         connector.segment(xStartCv2, xStartKnob2, yStartCv2, yStartKnob2, curve2),
         connector.segment(xStartCv3, xStartKnob3, yStartCv3, yStartKnob3, curve3),
         connector.segment(xStartCv4, xStartKnob4, yStartCv4, yStartKnob4, curve4),
         connector.segment(xStartCv5, xStartKnob5, yStartCv5, yStartKnob5, curve5),
         connector.segment(xStartCv6, xStartKnob6, yStartCv6, yStartKnob6, curve6),
         connector.segment(xStartCv7, xStartKnob7, yStartCv7, yStartKnob7, curve7),
         connector.endSegment(yStartCv8, yStartKnob8));

      curveView = new CurveView(curveDisplay.GetBitmapWidth(), curveDisplay.GetBitmapHeight());
      StartGuiUpdateTimer(100);
      
      frequencySupplier = new FrequencySupplier(
         polyFrequencyIn::GetPolyValue,
         polyHardSyncIn::GetPolyValue,
         connector.polyFmControl(polyFreqMod, polyFreqModAmount, polyFMModeSwitch),
         connector.fmControl(monoFreqMod, monoFreqModAmount, monoFMModeSwitch),
         eventConnector.connectSmoothedKnob(pitchKnob));
      
      eventConnector.connectToggles(frequencySupplier::setBaseFrequency,
         freqRangeLo, freqRange32, freqRange16,
         freqRange8, freqRange4, freqRange2);
         
      oscillatorController = new OscillatorController(
         frequencySupplier,
         connector.syncControl(polyHardSyncIn),
         polyOutput::SetPolyValue,
         curveControl,
         curveView);
         
      oscillatorController.setNumberOfVoices(GetNumberOfPolyVoices());
      //[/user-Initialize]
   }


   //-------------------------------------------------------------------------------
   //  public void Destroy()

      //  Destroy will get called just before your module gets deleted. You can use it to perform any
      //  cleanup that's not handled automatically by Java.
   //-------------------------------------------------------------------------------
   @Override
   public void Destroy()
   {
      super.Destroy();
      //[user-Destroy]   Add your own module-getting-deleted code here



      //[/user-Destroy]
   }


   //-------------------------------------------------------------------------------
   //  public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )

      //  Notify will get called when various events occur - control values changing, timers firing, etc.
   //-------------------------------------------------------------------------------
   @Override
   public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )
   {
      //[user-Notify]   Add your own notification handling code between this line and the notify-close comment
      switch( notification )
      {
         case Knob_Changed: return eventHandler.onKnobValueChanged(component, doubleValue); 
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
         }
         break;
      
         case Button_Changed: return eventHandler.onButtonChanged(component, doubleValue);
      
         case Switch_Changed: return eventHandler.onSwitchChanged(component, doubleValue);
      
         case Jack_Connected: return eventHandler.onJackConnected(component);  // longValue is the new cable ID
         
      
         case Jack_Disconnected: return eventHandler.onJackDisconnected(component);
      
         case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
         {
            curveDisplay.Invalidate();
         }
         break;
      
         case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_RightButtonDown:   // called when user releases right mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_RightButtonUp:   // called when user right-clicks on an object that receives mouse notifications
         {
         }
         break;
      
         case Object_LeftButtonDoubleClick: // called when user left-button double-clicks on an object that receives mouse notifications
         {
         }
         break;
      
         // Less common notifications:
      
         case Named_Timer:   // object contains a String with the name of the timer that has fired
         {
         }
         break;
      
         case Canvas_Painting:   // About to paint canvas.  object is a java.awt.Rectangle with painting boundaries
         {
            curveView.drawCurve(curveDisplay.GetGraphics());
         }
         break;
      
         case Canvas_Painted:   // Canvas painting is complete
         {
         }
         break;
      
         case Control_DragStart:    // A user has started dragging on a control that has been marked as draggable
         {
         }
         break;
      
         case Control_DragOn:       // This control has been dragged over during a drag operation. object contains the dragged object
         {
         }
         break;
      
         case Control_DragOff:      // This control has been dragged over during a drag operation. object contains the dragged object
         {
         }
         break;
      
         case Control_DragEnd:      // A user has ended their drag on a control that has been marked as draggable
         {
         }
         break;
      
         case Label_Changed:        // The text of an editable text control has changed
         {
         }
         break;
      
         case SoundPlayback_Start:   // A sound has begun playback
         {
         }
         break;
      
         case SoundPlayback_End:     // A sound has ended playback
         {
         }
         break;
      
         case Scrollbar_Position:    // longValue is the new scrollbar position
         {
         }
         break;
      
         case PolyVoices_Changed:    // longValue is the new number of poly voices
         {
            oscillatorController.setNumberOfVoices((int) longValue);
         }
         break;
      
         case File_Dropped:     // 'object' is a String containing the file path
         {
         }
         break;
      
         case Preset_Loading_Start:   // called when preset loading begins
         {
         }
         break;
      
         case Preset_Loading_Finish:  // called when preset loading finishes
         {
         }
         break;
      
         case Variation_Loading_Start:    // sent when a variation is about to load
         {
         }
         break;
      
         case Variation_Loading_Finish:   // sent when a variation has just finished loading
         {
         }
         break;
      
         case Tempo_Changed:     // doubleValue is the new tempo
         {
         }
         break;
      
         case Randomized:     // called when the module's controls get randomized
         {
         }
         break;
      
         case VariationListChanged:   // sent when a variation gets added, deleted, or renamed, or the variations list gets reordered
         {
         }
         break;
      
         case Key_Press:     // sent when module has keyboard focus and a key is pressed; object is a VoltageKeyPressInfo object
         {
         }
         break;
      
         case Reset:    // sent when the module has been reset to default settings
         {
         }
         break;
      
         case Keyboard_NoteOn:   // sent when a note has been pressed on a VoltageKeyboard object. longValue is the note value ( 0-127 )
         {
         }
         break;
      
         case Keyboard_NoteOff:   // sent when a note has been released on a VoltageKeyboard object. longValue is the note value ( 0-127 )
         {
         }
         break;
      
         case Curve_Changed:   // sent when user has edited a curve's value. 'object' will be a VoltageCurve.CurveChangeNotification object.
         {
         }
         break;
      }



      return false;
      //[/user-Notify]
   }


   //-------------------------------------------------------------------------------
   //  public void ProcessSample()

      //  ProcessSample is called once per sample. Usually it's where you read
      //  from input jacks, process audio, and write it to your output jacks.
      //  Since ProcesssSample gets called 48,000 times per second, offload CPU-intensive operations
      //  to other threads when possible and avoid calling native functions.
   //-------------------------------------------------------------------------------
   @Override
   public void ProcessSample()
   {
      //[user-ProcessSample]   Add your own process-sampling code here
      oscillatorController.processSample();
      //[/user-ProcessSample]
   }


   //-------------------------------------------------------------------------------
   //  public String GetTooltipText( VoltageComponent component )

      //  Gets called when a tooltip is about to display for a control. Override it if
      //  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
      //  for instance, you can translate the knob's current value to a log-based string and display it here.
   //-------------------------------------------------------------------------------
   @Override
   public String GetTooltipText( VoltageComponent component )
   {
      //[user-GetTooltipText]   Add your own code here
      if (component.GetDisplayName().startsWith("Curve")) {
         return CurveType.valueOf(component.GetValue()).getName();
      }


      return super.GetTooltipText( component );
      //[/user-GetTooltipText]
   }


   //-------------------------------------------------------------------------------
   //  public void EditComponentValue( VoltageComponent component, double newValue, String newText )

      //  Gets called after a user clicks on a tooltip and types in a new value for a control. Override this if
      //  you've changed the default tooltip display (translating a linear value to logarithmic, for instance)
      //  in GetTooltipText().
   //-------------------------------------------------------------------------------
   @Override
   public void EditComponentValue( VoltageComponent component, double newValue, String newText )
   {
      //[user-EditComponentValue]   Add your own code here



      //[/user-EditComponentValue]
      super.EditComponentValue( component, newValue, newText );
   }


   //-------------------------------------------------------------------------------
   //  public void OnUndoRedo( String undoType, double newValue, Object optionalObject )

      //  If you've created custom undo events via calls to CreateUndoEvent, you'll need to
      //  process them in this function when they get triggered by undo/redo actions.
   //-------------------------------------------------------------------------------
   @Override
   public void OnUndoRedo( String undoType, double newValue, Object optionalObject )
   {
      //[user-OnUndoRedo]   Add your own code here



      //[/user-OnUndoRedo]
   }


   //-------------------------------------------------------------------------------
   //  public byte[] GetStateInformation()

      //  Gets called when the module's state gets saved, typically when the user saves a preset with
      //  this module in it. Voltage Modular will automatically save the states of knobs, sliders, etc.,
      //  but if you have any custom state information you need to save, return it from this function.
   //-------------------------------------------------------------------------------
   @Override
   public byte[] GetStateInformation()
   {
      //[user-GetStateInformation]   Add your own code here



      return null;
      //[/user-GetStateInformation]
   }


   //-------------------------------------------------------------------------------
   //  public void SetStateInformation(byte[] stateInfo)

      //  Gets called when this module's state is getting restored, typically when a user opens a preset with
      //  this module in it. The stateInfo parameter will contain whatever custom data you stored in GetStateInformation().
   //-------------------------------------------------------------------------------
   @Override
   public void SetStateInformation(byte[] stateInfo)
   {
      //[user-SetStateInformation]   Add your own code here



      //[/user-SetStateInformation]
   }


   //-------------------------------------------------------------------------------
   //  public byte[] GetStateInformationForVariations()

      //  Gets called when a user saves a variation with this module in it.
      //  Voltage Modular will automatically save the states of knobs, sliders, etc.,
      //  but if you have any custom state information you need to save, return it from this function.
   //-------------------------------------------------------------------------------
   @Override
   public byte[] GetStateInformationForVariations()
   {
      //[user-GetStateInformationForVariations]   Add your own code here



      return GetStateInformation();
      //[/user-GetStateInformationForVariations]
   }


   //-------------------------------------------------------------------------------
   //  public void SetStateInformationForVariations(byte[] stateInfo)

      //  Gets called when a user loads a variation with this module in it.
      //  The stateInfo parameter will contain whatever custom data you stored in GetStateInformationForVariations().
   //-------------------------------------------------------------------------------
   @Override
   public void SetStateInformationForVariations(byte[] stateInfo)
   {
      //[user-SetStateInformationForVariations]   Add your own code here
      SetStateInformation(stateInfo);



      //[/user-SetStateInformationForVariations]
   }


   // Auto-generated variables
   private VoltageSwitch monoFMModeSwitch;
   private VoltageLabel textLabel19;
   private VoltageLabel textLabel18;
   private VoltageLabel textLabel17;
   private VoltageLabel textLabel16;
   private VoltageSwitch polyFMModeSwitch;
   private VoltageLabel textLabel15;
   private VoltageLabel textLabel14;
   private VoltageLabel textLabel13;
   private VoltageLabel textLabel11;
   private VoltageLabel textLabel8;
   private VoltageLabel textLabel7;
   private VoltagePolyJack polyOutput;
   private VoltageToggle freqRange2;
   private VoltageToggle freqRange4;
   private VoltageToggle freqRange8;
   private VoltageToggle freqRange16;
   private VoltageToggle freqRange32;
   private VoltageToggle freqRangeLo;
   private VoltageKnob polyFreqModAmount;
   private VoltageKnob monoFreqModAmount;
   private VoltageKnob pitchKnob;
   private VoltageAudioJack monoFreqMod;
   private VoltagePolyJack polyFreqMod;
   private VoltagePolyJack polyHardSyncIn;
   private VoltagePolyJack polyFrequencyIn;
   private VoltageLabel textLabel6;
   private VoltageLabel textLabel5;
   private VoltageLabel textLabel10;
   private VoltageLabel textLabel9;
   private VoltageLabel textLabel4;
   private VoltageCanvas curveDisplay;
   private VoltageKnob curve6;
   private VoltageKnob curve4;
   private VoltageKnob curve7;
   private VoltageKnob curve1;
   private VoltageKnob curve3;
   private VoltageKnob curve2;
   private VoltageKnob curve5;
   private VoltageKnob yStartKnob8;
   private VoltageKnob yStartKnob2;
   private VoltageKnob yStartKnob7;
   private VoltageKnob yStartKnob4;
   private VoltageKnob yStartKnob5;
   private VoltageKnob yStartKnob3;
   private VoltageKnob yStartKnob6;
   private VoltageKnob yStartKnob1;
   private VoltageAudioJack yStartCv8;
   private VoltageAudioJack yStartCv7;
   private VoltageAudioJack yStartCv1;
   private VoltageAudioJack yStartCv3;
   private VoltageAudioJack yStartCv6;
   private VoltageAudioJack yStartCv4;
   private VoltageAudioJack yStartCv2;
   private VoltageAudioJack yStartCv5;
   private VoltageKnob xStartKnob7;
   private VoltageKnob xStartKnob4;
   private VoltageKnob xStartKnob6;
   private VoltageKnob xStartKnob2;
   private VoltageKnob xStartKnob5;
   private VoltageKnob xStartKnob3;
   private VoltageAudioJack xStartCv7;
   private VoltageAudioJack xStartCv6;
   private VoltageAudioJack xStartCv5;
   private VoltageAudioJack xStartCv4;
   private VoltageAudioJack xStartCv3;
   private VoltageAudioJack xStartCv2;
   private VoltageLabel textLabel3;
   private VoltageLabel textLabel2;


   //[user-code-and-variables]    Add your own variables and functions here
private final EventBus eventBus = new EventBus();
private final UIEventConnector eventConnector = new UIEventConnector(eventBus);
private final UIEventHandler eventHandler = new UIEventHandler(eventBus);
private final Connector connector = new Connector(eventConnector);

private CurveControl curveControl;
private CurveView curveView;
private FrequencySupplier frequencySupplier;
private OscillatorController oscillatorController;
   //[/user-code-and-variables]
}

 