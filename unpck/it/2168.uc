class 2168 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect3
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.su_empower_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect4
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.su_might_ta'
	End Object
	Desc="행운의 부적" //Good Luck Charm
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect3',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect4',SpecificStage=0)
}