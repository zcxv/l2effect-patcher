class 273 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect12
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.ph_dance_of_mystic_ta'
	End Object
	Desc="댄스 오브 미스틱" //Dance of Mystic
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect12',SpecificStage=0)
}