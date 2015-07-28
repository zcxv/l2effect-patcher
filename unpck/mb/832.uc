class 832 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect42
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-20.500000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u832_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect43
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-20.500000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u832'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect12
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-20.500000)
		bRelativeToCylinder=False
	End Object
	Desc="사이렌자기버프" //Self Buff siren
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect42',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect43',SpecificStage=0)
	CastingActions(2)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect12',SpecificStage=0)
}